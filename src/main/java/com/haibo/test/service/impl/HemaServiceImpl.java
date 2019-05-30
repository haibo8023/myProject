//package com.haibo.test.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.haibo.test.utils.HttpClientUtil;
//import com.haibo.test.utils.MailService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author XD
// * @date 2018/8/23 12:00
// */
//@Slf4j
//@Service
//public class HemaServiceImpl {
//    private static String userAgent = "Mozilla/5.0 (Linux; Android 8.0.0; MI 5s Build/OPR1.170623.032; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36 DKKJ/5.0.1/[DKKJ_TOWER_1.3] dkkj_channel_id/02xxSCxxTQ";
//    private static String userAgent1 = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16B92 DKKJ/5.0.3/[DKKJ_TOWER_1.2] DKKJ_V4 dkkj_channel_id/AppStore";
////    @Scheduled(fixedRate = 100)
//    public void testMain(String cookie1,String cookie2) throws Exception {
//        String url = "https://eshop.creditcard.ecitic.com/citiccard/coupon/acquireCoupon.do";
//        List<String> list = Arrays.asList("DLL101901","DLL101902","DLL101903");
//        try {
//            for(String activityId:list){
//                JSONObject createMap = new JSONObject();
//                createMap.put("activityId", activityId);
//                String result1 = HttpClientUtil.doPost(url, createMap, userAgent, cookie1);
//                String result2 = HttpClientUtil.doPost(url, createMap, userAgent1, cookie2);
//                JSONObject jsStr1 = JSONObject.parseObject(result1);
//                JSONObject jsStr2 = JSONObject.parseObject(result2);
//                if (null != jsStr1) {
//                    System.out.println("1111111111111----第一个号"+jsStr1.toJSONString());
//                }
//                if (null != jsStr2) {
//                    System.out.println("222222222----第二个号"+jsStr2.toJSONString());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//        }
//    }
//
////    @Scheduled(cron = "0 */1 * * * ?")
//    public void tianfu() throws Exception {
//        String sid = "886ca62f-e7cb-464d-8fa5-78ec540faa6b:15808";
//        String url = "https://b.zaodoo.com/api/gift/25";
//        String pushUrl = "https://sc.ftqq.com/SCU41383Tc41442b5379b1ad2f0ec602a2dab022f5c3edd2b5fcc6.send?text=天府通有库存了";
//        try {
//            String httpOrgCreateTestRtn = HttpClientUtil.doGet(url, null);
//            JSONObject jsStr = JSONObject.parseObject(httpOrgCreateTestRtn);
//            if (null != jsStr) {
//                System.out.println(jsStr.toJSONString());
//                Integer total = Integer.parseInt(String.valueOf(jsStr.get("total")));
//                Integer occupied = Integer.parseInt(String.valueOf(jsStr.get("occupied")));
//                if (total - occupied > 0) {
//                    MailService.sendHtmlMail("15756308704@139.com", "天府通有库存了", String.valueOf(total - occupied));
//                    String ss = HttpClientUtil.doGet(pushUrl, null);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//        }
//    }
//}
