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
    private static String userAgent = "Mozilla/5.0 (Linux; Android 8.0.0; MI 5s Build/OPR1.170623.032; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/044506 Mobile Safari/537.36 MMWEBID/9939 MicroMessenger/7.0.3.1400(0x2700033B) Process/tools NetType/WIFI Language/zh_CN";
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
                .setConnectTimeout(10).setConnectionRequestTimeout(10)
                .setSocketTimeout(10).build();
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
            httpGet.addHeader("st","dc06a3c4de66e7612016ba9225d05340");
            httpGet.addHeader("tk","7a2615294971e5e8a5af670bacafcf89_578482e75a975e212c2938f6e62c9807");
            httpGet.addHeader("Cookie","UM_distinctid=1697ed9e5ab7-08abc69a284f5d-650e7724-38400-1697ed9e5ad55; _xzkj_=7a2615294971e5e8a5af670bacafcf89_578482e75a975e212c2938f6e62c9807; _xxhm_=%7B%22address%22%3A%22%22%2C%22awardPoints%22%3A0%2C%22birthday%22%3A792691200000%2C%22createTime%22%3A1512449976000%2C%22headerImg%22%3A%22http%3A%2F%2Fthirdwx.qlogo.cn%2Fmmopen%2FQ3auHgzwzM5oMwqibf8N4BiaSnIqpomvibTwE2SnGKLf28WCUBl8riaLSGVf1ULHibvlMPbgq54BCicbBOgfb7tDhzEg%2F132%22%2C%22id%22%3A680626%2C%22idCardNo%22%3A%22513030199502145624%22%2C%22isRegisterHistory%22%3A0%2C%22latitude%22%3A30.782467%2C%22longitude%22%3A103.85257%2C%22mobile%22%3A%2215756308704%22%2C%22modifyTime%22%3A1552973472000%2C%22name%22%3A%22%E6%9D%8E%E5%A9%B7%22%2C%22nickName%22%3A%22%E6%B5%B7%E6%B3%A2%22%2C%22openId%22%3A%22og46NxJXEc1a-A8DxVnWI8XbZ6kg%22%2C%22regionCode%22%3A%22510108%22%2C%22registerTime%22%3A1551575558000%2C%22sex%22%3A2%2C%22source%22%3A1%2C%22uFrom%22%3A%22depa_vacc_detail%22%2C%22unionid%22%3A%22o8NLkwakY18X3htJiucxnLRO4zmw%22%2C%22wxSubscribed%22%3A1%2C%22yn%22%3A1%7D; CNZZDATA1261985103=1274081954-1552606006-%7C1552973861");
            httpGet.setHeader("content-type","application/json;charset=utf-8");
            httpGet.setHeader("User-Agent", userAgent);
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