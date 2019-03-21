package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.model.domain.Day;
import com.haibo.test.model.domain.KillDetail;
import com.haibo.test.utils.DateUtil;
import com.haibo.test.utils.HttpClientUtil;
import com.haibo.test.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Service
@Slf4j
public class KillServiceImpl {
    //    seckillDetail: seckill + 'vaccine/detail.do', //秒杀详情接口
//    seckillCheckstock: seckill + 'vaccine/checkstock.do', //库存检测接口
//    seckillDetailVo: seckill + 'vaccine/detailVo.do', //秒杀疫苗下单的详情
//    submitSeckill: seckill + 'vaccine/subscribe.do' , //秒杀下单接口
    private static String seckillDetail = "https://wx.healthych.com/seckill/vaccine/detail.do.do?";
    private static String seckillCheckstock = "https://wx.healthych.com/seckill/vaccine/checkstock.do?";
    private static String seckillDetailVo = "https://wx.healthych.com/seckill/vaccine/detailVo.do?";
    private static String submitSeckill = "https://wx.healthych.com/seckill/vaccine/subscribe.do?";
    private static String vaccCode = "8803";
    private static String linkmanId = "2546588";
    private static Integer departmentVaccineId = 3560;

    //    @Scheduled(fixedRate = 10)
    @Test
    public void testMain() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("ss SSS");
        String url2 = seckillCheckstock + "id=" + departmentVaccineId;
        String result2 = HttpClientUtil.doGet(url2, null);
        JSONObject jsStr2 = JSONObject.parseObject(result2);
        log.warn(sdf.format(new Date()) + "  :seckillCheckstock" + jsStr2.get("data").toString());
        Integer data = Integer.parseInt(String.valueOf(jsStr2.get("data")));
        if (data > 0) {
            String url3 = seckillDetailVo + "id=" + departmentVaccineId;
            String result3 = HttpClientUtil.doGet(url3, null);
            JSONObject jsStr3 = JSONObject.parseObject(result3);
            log.warn(sdf.format(new Date()) + "  :seckillDetailVo" + jsStr3.get("data").toString());
            KillDetail killDetail = JSONObject.toJavaObject(jsStr3, KillDetail.class);
            if (killDetail.getCode().equals("0000")) {
                List<Day> dateList = killDetail.getData().getDays();
                if (!CollectionUtils.isEmpty(dateList)) {
                    for (Day day : dateList) {
                        if (day.getTotal() > 0) {
                            String dateValue = DateUtil.strToDateFormat(day.getDay());
                            String sign = MD5Utils.MD5Encode(killDetail.getData().getTime() + "healthych.com", "utf8");
                            String url4 = submitSeckill + "departmentVaccineId=" + departmentVaccineId + "&vaccineIndex=1&linkmanId=" + linkmanId + "&subscribeDate=" + dateValue + "&sign=" + sign;
                            String result4 = HttpClientUtil.doGet(url4, null);
                            JSONObject jsStr4 = JSONObject.parseObject(result4);
                            log.warn(sdf.format(new Date()) + "  :submitSeckill" + jsStr4.toJSONString());
                        }
                    }
                }

            }
        }
    }
}
