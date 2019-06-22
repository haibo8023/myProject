package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.constant.PublicConstant;
import com.haibo.test.model.domain.Day;
import com.haibo.test.model.domain.KillDetail;
import com.haibo.test.utils.Base64Util;
import com.haibo.test.utils.DateUtil;
import com.haibo.test.utils.HttpClientUtils;
import com.haibo.test.utils.MD5Utils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Service
public class Kill1ServiceImpl {
    private static String seckillDetailVo = "https://wx.healthych.com/seckill/vaccine/detailVo.do?";
    private static String submitSeckill = "https://wx.healthych.com/seckill/vaccine/subscribe.do?";
    private static String validateCode = "https://wx.healthych.com/seckill/validateCode/vcode.do";
    private static Integer departmentVaccineId = 4640;//航天社区

    @Scheduled(fixedRate = 100)
//    @Test
    public void testMain() throws Exception {
        HttpClientUtils httpClientUtil = new HttpClientUtils();
        String url = seckillDetailVo + "id=" + departmentVaccineId;
        String result = httpClientUtil.sendGet(url, null);
        JSONObject jsStr = JSONObject.parseObject(result);
        if (null == result) {
            return;
        }
        KillDetail killDetail = JSONObject.toJavaObject(jsStr, KillDetail.class);
        if (killDetail.getCode().equals("0000")) {
            List<Day> dateList = killDetail.getData().getDays();
            if (!CollectionUtils.isEmpty(dateList)) {
                for (Day day : dateList) {
                    if (day.getTotal() > 0) {
                        String dateValue = DateUtil.strToDateFormat(day.getDay());
                        String sign = MD5Utils.MD5Encode(killDetail.getData().getTime() + "fuckhacker10000times", "utf8");
                        String result2 = httpClientUtil.sendGet(validateCode, null);
                        JSONObject jsStr2 = JSONObject.parseObject(result2);
                        String vcode= Base64Util.Base64ToImage(jsStr2.getString("data"));
                        String url3 = submitSeckill + "departmentVaccineId=" + departmentVaccineId + "&vaccineIndex=1&linkmanId=" + PublicConstant.linkmanId + "&subscribeDate=" + dateValue + "&sign=" + sign+"&vcode="+vcode;
                        String result3 = httpClientUtil.sendGet(url3, null);
                        JSONObject jsStr3 = JSONObject.parseObject(result3);
                        System.out.println(dateValue + "秒杀结果" + jsStr3.toJSONString());
                    }
                }
            }
        }

    }
}
