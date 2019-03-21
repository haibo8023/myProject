package com.haibo.test.utils;


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
    private static String seckillDetailVo = "https://wx.healthych.com/seckill/vaccine/detailVo.do?id=3560";
    private static String submitSeckill = "https://wx.healthych.com/seckill/vaccine/subscribe.do?";
    private static String linkmanId = "489926";
    private static String dateValue = "2019-03-21";

    @org.junit.Test
    public void test() throws Exception {
//        String result1 = HttpClientUtil.doGet(seckillDetailVo, null);
//        JSONObject jsStr1 = JSONObject.parseObject(result1);
        Long time = 1553133471395L;
        String sign = MD5Utils.MD5Encode(time + "healthych.com", "utf8");
        String url4 = submitSeckill + "departmentVaccineId=" + 8502 + "vaccineIndex=1&linkmanId=" + linkmanId + "&subscribeDate=" + dateValue + "&sign=" + sign;
        System.out.println(url4);
    }
}
