package com.haibo.test.utils;


import com.haibo.test.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @author XD
 * @date 2019/1/11 11:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
    private static String seckillDetailVo = "https://wx.healthych.com/seckill/vaccine/detailVo.do?id=3852";
    private static String submitSeckill = "https://wx.healthych.com/seckill/vaccine/subscribe.do?";
    private static String linkmanId = "489926";
    private static String dateValue = "2019-03-21";

    @org.junit.Test
    public void test() throws Exception {
        HttpClientUtils httpClientUtil = new HttpClientUtils();
//        String result1 = HttpClientUtil.doGet(seckillDetailVo, null);
//        String result1 = HttpClientUtil.doGet(seckillDetailVo, null);
//        JSONObject jsStr1 = JSONObject.parseObject(result1);
//        System.out.println(jsStr1.toJSONString());
        long start1 = System.currentTimeMillis();
        for(int i = 0;i<15;i++){
            try {
                HttpClientUtil.doGet(seckillDetailVo, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        for (int i = 0;i<15;i++) {
            try {               httpClientUtil.sendGet(seckillDetailVo, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long end2 = System.currentTimeMillis();
        long start3 = System.currentTimeMillis();
        for(int i = 0;i<15;i++){
            try {
                HttpUtils.sendGet(seckillDetailVo, new HashMap<String, Object>());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long end3 = System.currentTimeMillis();
        System.out.println("时间1:" + (end1 - start1) + "时间2:" + (end2 - start2)+ "时间3:" + (end3 - start3));
    }
}
