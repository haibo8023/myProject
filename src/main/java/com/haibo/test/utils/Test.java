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
    private static String url = "https://enjoy.abchina.com/yh-web/customer/giftTokenDraw";
    private static String cookie = "route=86c65ab2abd1087881cc394e170d71ac; orderNo=YH181208231540596083; BIGipServerpool_sclf_yx_web=2364402442.47138.0000; BIGipServerpool_sclf_yh=3186420490.47138.0000; BIGipServerpool_sclf_yh_web=3186420490.47138.0000; sclfyxlife_abchina_mobile_id=1D1HRM262TDK93EDEB0A0000506770EC";
    private static String userAgent = "Mozilla/5.0 (Linux; Android 8.0.0; MI 5s Build/OPR1.170623.032; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36 BankabcAndroid/3.9.7 SDKVersion/26";

    @org.junit.Test
    public void test() throws Exception {
//        JSONObject createMap = new JSONObject();
//        createMap.put("sessionId", "{ps_2366ded750f442b6d580fb4dffa3a2e2}_common");
//        createMap.put("ruleNo", "084165");
//        createMap.put("actNo", "999999CXE00084162");
//        createMap.put("discType", "12");
//        createMap.put("actType", "E");
//        createMap.put("appr", "10");
//        String result = HttpClientUtil.doPost(url, createMap, userAgent, cookie);
//        JSONObject jsStr1 = JSONObject.parseObject(result);
//        System.out.println(jsStr1.toJSONString());
    }
}
