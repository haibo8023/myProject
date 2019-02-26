package com.haibo.test.utils;


import com.alibaba.fastjson.JSONObject;
import com.haibo.test.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XD
 * @date 2019/1/11 11:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
    private static String zhengxing = "https://wx.healthych.com/order/subscribe/workDays.do?depaCode=5101850004&vaccCode=8803&departmentVaccineId=3578&vaccineIndex=1";
    private static String wanan = "https://wx.healthych.com/order/subscribe/workDays.do?depaCode=5101850005&vaccCode=8803&departmentVaccineId=3577&vaccineIndex=1";
    private static String maliya = "https://wx.healthych.com/order/subscribe/workDays.do?depaCode=5101850006&vaccCode=8803&departmentVaccineId=3587&vaccineIndex=1";
    private static String commiturl = "https://wx.healthych.com/order/subscribe/add.do?depaCode=5101850004&vaccineCode=8803&vaccineIndex=1&linkmanId=545831&subscribeDate=2019-02-28&subscirbeTime=1140&departmentVaccineId=3578";
    private static String getDateId = "https://wx.healthych.com/order/subscribe/departmentWorkTimes.do?depaCode=5101850006&vaccCode=8803&vaccIndex=1&subsribeDate=2019-02-28&departmentVaccineId=3587&linkmanId=545831";


    @org.junit.Test
    public void test() throws Exception {
        String result = HttpClientUtil.doGet(getDateId, null);
        JSONObject jsStr1 = JSONObject.parseObject(result);
        System.out.println(jsStr1.toJSONString());
    }
}
