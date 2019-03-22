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
    private static String userAgent1 = "Mozilla/5.0 (Linux; Android 8.0.0; MI 5s Build/OPR1.170623.032; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/044506 Mobile Safari/537.36 MMWEBID/9939 MicroMessenger/7.0.3.1400(0x2700033B) Process/tools NetType/WIFI Language/zh_CN";
    private static String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 MicroMessenger/7.0.3(0x17000321) NetType/WIFI Language/zh_CN";
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
            httpGet.addHeader("st","7191c46336144e614bbaf6964543efc3");
            httpGet.addHeader("tk","24fad0f25aa79cf3b701a15f64c9276f_3e752f25b427934398e735fa3a33c54a");
            httpGet.addHeader("Cookie","CNZZDATA1261985103=310063453-1552971105-%7C1553212068; _xxhm_=%7B%22address%22%3A%22%22%2C%22awardPoints%22%3A0%2C%22birthday%22%3A792691200000%2C%22createTime%22%3A1545094567000%2C%22headerImg%22%3A%22http%3A%2F%2Fthirdwx.qlogo.cn%2Fmmopen%2FP56jzUdF1RGL2ib6af1W5eOicKGb2O52LkbdSNTcQUdgu8mlHGib6vdMCFsHHq2WNglIsn93CDBVnQ32TibEaSdum8iaQOPXHHs2j%2F132%22%2C%22id%22%3A2546588%2C%22idCardNo%22%3A%22513030199502145624%22%2C%22isRegisterHistory%22%3A0%2C%22latitude%22%3A0.0%2C%22longitude%22%3A0.0%2C%22mobile%22%3A%2219956034358%22%2C%22modifyTime%22%3A1553143493000%2C%22name%22%3A%22%E6%9D%8E%E5%A9%B7%22%2C%22nickName%22%3A%22%E5%AE%88%E6%8A%A4%E6%98%9F%22%2C%22openId%22%3A%22og46NxIukAn0AXBIShtCYfvVd0io%22%2C%22regionCode%22%3A%22510108%22%2C%22registerTime%22%3A1551169361000%2C%22sex%22%3A2%2C%22source%22%3A1%2C%22uFrom%22%3A%22depa_vacc_detail%22%2C%22unionid%22%3A%22o8NLkwUU3vS3xR8QGXO-FOO3Hx1w%22%2C%22wxSubscribed%22%3A1%2C%22yn%22%3A1%7D; _xzkj_=24fad0f25aa79cf3b701a15f64c9276f_3e752f25b427934398e735fa3a33c54a; UM_distinctid=169946a24db1ef-05cfdfdbdaebe58-7e145f62-3d10d-169946a24dc1fe");
            httpGet.setHeader("content-type","application/json;charset=utf-8");
            httpGet.setHeader("User-Agent", userAgent);
            httpGet.setHeader("Referer", "https://wx.healthych.com/index.html");
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }else {
                System.out.println("网页内容："+EntityUtils.toString(response.getEntity(), "utf-8")); // 获取网页内容
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