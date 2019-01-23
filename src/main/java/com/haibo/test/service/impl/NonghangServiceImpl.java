package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Slf4j
@Service
public class NonghangServiceImpl {
    private static String url = "https://enjoy.abchina.com/yh-web/customer/giftTokenDraw";
    private static String cookie = "route=86c65ab2abd1087881cc394e170d71ac; orderNo=YH181208231540596083; BIGipServerpool_sclf_yx_web=2364402442.47138.0000; BIGipServerpool_sclf_yh=3186420490.47138.0000; BIGipServerpool_sclf_yh_web=3186420490.47138.0000; sclfyxlife_abchina_mobile_id=1D1HRM262TDK93EDEB0A0000506770EC";
    private static String userAgent = "Mozilla/5.0 (Linux; Android 8.0.0; MI 5s Build/OPR1.170623.032; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36 BankabcAndroid/3.9.7 SDKVersion/26";

    @Scheduled(cron = "58 59 11 * * ? ")
    public void testMain() throws Exception {
        for (int i = 0; i < 100000000; i++) {
            JSONObject createMap = new JSONObject();
            createMap.put("sessionId", "{ps_2366ded750f442b6d580fb4dffa3a2e2}_common");
            createMap.put("ruleNo", "084165");
            createMap.put("actNo", "999999CXE00084162");
            createMap.put("discType", "12");
            createMap.put("actType", "E");
            createMap.put("appr", "10");
            String result = HttpClientUtil.doPost(url, createMap, userAgent, cookie);
            JSONObject jsStr = JSONObject.parseObject(result);
            System.out.println(jsStr.toJSONString());
            String resultMsg=String.valueOf(jsStr.get("result"));
            if(resultMsg.equals("客官，您已领过了哟，请至“我的-我的生活-优惠券”查看")){
                break;
            }
        }
    }
}
