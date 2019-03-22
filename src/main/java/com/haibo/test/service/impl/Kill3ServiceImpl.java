package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.constant.PublicConstant;
import com.haibo.test.model.domain.Day;
import com.haibo.test.model.domain.KillDetail;
import com.haibo.test.utils.DateUtil;
import com.haibo.test.utils.HttpUtils;
import com.haibo.test.utils.MD5Utils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Service
public class Kill3ServiceImpl {
    private static String seckillDetailVo = "https://wx.healthych.com/seckill/vaccine/detailVo.do?";
    private static String submitSeckill = "https://wx.healthych.com/seckill/vaccine/subscribe.do?";
    private static Integer departmentVaccineId = 3702;

        @Scheduled(fixedRate = 10)
//    @Test
    public void testMain() throws Exception {
            String url3 = seckillDetailVo + "id=" + departmentVaccineId;
            String result3 = HttpUtils.sendGet(url3, new HashMap<String, Object>());
            JSONObject jsStr3 = JSONObject.parseObject(result3);
            KillDetail killDetail = JSONObject.toJavaObject(jsStr3, KillDetail.class);
            if (killDetail.getCode().equals("0000")) {
                List<Day> dateList = killDetail.getData().getDays();
                if (!CollectionUtils.isEmpty(dateList)) {
                    for (Day day : dateList) {
                        if (day.getTotal() > 0) {
                            String dateValue = DateUtil.strToDateFormat(day.getDay());
                            String sign = MD5Utils.MD5Encode(killDetail.getData().getTime() + "healthych.com", "utf8");
                            String url4 = submitSeckill + "departmentVaccineId=" + departmentVaccineId + "&vaccineIndex=1&linkmanId=" + PublicConstant.linkmanId + "&subscribeDate=" + dateValue + "&sign=" + sign;
                            String result4 = HttpUtils.sendGet(url4, new HashMap<String, Object>());
                            JSONObject jsStr4 = JSONObject.parseObject(result4);
                            System.out.println("submitSeckill" + jsStr4.toJSONString());
                        }
                    }
                }
            }

    }
}
