package com.haibo.test.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.utils.HttpClientUtil;
import com.xdbigdata.framework.web.model.JsonResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XD
 */
@RestController
@RequestMapping("/api")
@Api(description = "移动端选课接口列表")
public class SelectionController {
    private HttpClientUtil httpClientUtil = null;
    private HttpClientUtil httpClient = null;
    private static String charset = "utf-8";
    private static String customer = "iH1wXuzdLqr6An16MOgpJhaHMHWbambYYyjAcMjLFI68e6tKBtUUJ9Un_NLYohUmzlMLwp_XulALwFxJYiBadxB2s_9mw5zabDtaYr3CRtPuHlQYk9G3AVSum9HtpK9eOejmTymhkqD7Rf2LtQ3ZzMrKZr4NCpTrmm6jRqMSg9M%3D";
    private static String rankUrl = "https://www.jiyou-tech.com/2018/287/php/get_rank.php";
    private static String infoUrl = "https://www.jiyou-tech.com/2018/287/php/info.php";

    @GetMapping("/getRank")
    public JsonResponse getRank() {
        httpClientUtil = new HttpClientUtil();
        Map<String, String> createMap = new HashMap<String, String>();
        createMap.put("customer", customer);
        String httpOrgCreateTestRtn = httpClientUtil.doPost(rankUrl, createMap, charset);
        JSONObject jsonObject = JSONObject.parseObject(httpOrgCreateTestRtn);
        return JsonResponse.success(jsonObject);
    }

    @GetMapping("/getInfo")
    public JsonResponse getInfo() {
        httpClient = new HttpClientUtil();
        Map<String, String> createMap = new HashMap<String, String>();
        createMap.put("customer", customer);
        String httpOrgCreateTestRtn = httpClient.doPost(infoUrl, createMap, charset);
        JSONObject jsonObject = JSONObject.parseObject(httpOrgCreateTestRtn);
        return JsonResponse.success(jsonObject);
    }
}
