package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.service.HttpRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XD
 * @date 2018/8/23 12:00
 */
@Slf4j
@Service
public class HttpRequestServiceImpl implements HttpRequestService {
    private static String userAgent1 = " Mozilla/5.0 (Linux; Android 8.0.0; MI 5s Build/OPR1.170623.032; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/WIFI Language/zh_CN Process/appbrand3";
    private static String userAgent2 = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16B92 MicroMessenger/6.7.4(0x1607042c) NetType/WIFI Language/zh_CN";

    @Override
    public String testMain(String cookie1, String cookie2) throws Exception {
        String commitUrl = "https://s.creditcard.ecitic.com/citiccard/gwapi/winterpig/assistance/enjoy";
        try {
            JSONObject createMap = new JSONObject();
            createMap.put("unionidSrc", "6Zz01ddITzQV0A9yu2LlXJFm5pvahwsw1x5NGn+bC3OytMzxNzCGjcgAZ+zQtBHv/IABnSev4OCQ3a9JN6onEA==");
            createMap.put("wx_header", "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eprZkiagDicBT0EQeL9uibjvrYzs3E8NwwV5EhJNckMBXeEfiacfQrc9yl38C4mD5RvWy1IHgeqNRWF9g/132");
            createMap.put("wx_nickname", "海波");
            JSONObject createMap2 = new JSONObject();
            createMap2.put("unionidSrc", "6Zz01ddITzQV0A9yu2LlXEOo4HVEbaPH86ouu5/9zmcswZzIbXPjwxNhe82BGMPNfWUVaFwHtxla8kIASgNIvg==");
            createMap2.put("wx_header", "https://wx.qlogo.cn/mmopen/vi_32/UYgjnvRAsn9ibHakdyU1oVAbpxWIegJT904ZjwHxhNv0Cp7uhkg26JAO1yOaVwdUWKBt7VusRicNUIsbZVmQhGibg/132");
            createMap2.put("wx_nickname", "守护星");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "处理成功";
    }
}
