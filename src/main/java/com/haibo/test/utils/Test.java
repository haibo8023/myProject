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
    private static long l = 86400000L;
    private static String seckillDetailVo = "https://wx.healthych.com/seckill/vaccine/detailVo.do?id=3852";
    private static String validateCode = "https://wx.healthych.com/seckill/validateCode/vcode.do";
    private static String submitSeckill = "https://wx.healthych.com/seckill/vaccine/subscribe.do?";
    private static String linkmanId = "489926";
    private static String dateValue = "2019-06-05";

    @org.junit.Test
    public void test() throws Exception {
        HttpClientUtils httpClientUtil = new HttpClientUtils();
        String result2 = httpClientUtil.sendGet(validateCode, null);
        JSONObject jsStr2 = JSONObject.parseObject(result2);
        String vcode= Base64Util.Base64ToImage(jsStr2.getString("data"));
        System.out.println(vcode);
    }
}
