package com.haibo.test.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil {
    private static String sid = "886ca62f-e7cb-464d-8fa5-78ec540faa6b:15808";
    public static String doPost(String url, JSONObject jsonObject, String userAgent, String cookie) throws Exception {
//        HttpClient httpClient = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(1000).setConnectionRequestTimeout(1000)
                    .setSocketTimeout(1000).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            //设置参数
            httpPost.addHeader("cache-control", "no-cache");
            httpPost.addHeader("Cookie", cookie);
            httpPost.addHeader("postman-token", "74162342-d591-d89c-2f7b-b949454bef22");
            httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpPost.addHeader("Connection", "keep-alive");
            httpPost.addHeader("content-type", "application/json;charset=utf-8");
            httpPost.addHeader("Referer", "https://servicewechat.com/wx13b9861d3e9fcdb0/9/page-frame.html");
            httpPost.addHeader("User-Agent", userAgent);
            if (null != jsonObject) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String doGet(String url, Map<String, String> param) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpclient = new SSLClient();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(10000).setConnectionRequestTimeout(10000)
                .setSocketTimeout(10000).build();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("sid",sid);
            httpGet.setHeader("content-type","application/json;charset=utf-8");
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

}