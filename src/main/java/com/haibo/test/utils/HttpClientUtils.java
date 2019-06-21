package com.haibo.test.utils;

import com.haibo.test.constant.PublicConstant;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;


/**
 * Created by xugang on 16/7/11.
 */
public class HttpClientUtils {
    private int maxTotal = 1;//默认最大连接数
    private int defaultMaxPerRoute = 1;//默认每个主机的最大链接数
    private int connectionRequestTimeout = 3000;//默认请求超时时间
    private int connectTimeout = 3000;//默认链接超时时间
    private int socketTimeout = 3000;//默认socket超时时间
    private HttpRequestRetryHandler httpRequestRetryHandler = new DefaultHttpRequestRetryHandler();//默认不进行重试处理
    private CloseableHttpClient httpClient;

    public HttpClientUtils() {
        init();
    }

    public String sendGet(String url, Map<String, Object> params) throws Exception {
        StringBuffer sb = new StringBuffer(url);
        if (!CollectionUtils.isEmpty(params)) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sb.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }
        // no matter for the last '&' character
        HttpGet httpget = new HttpGet(sb.toString());
        config(httpget);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpget, HttpClientContext.create());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null != response){
            if (null != response.getStatusLine()) {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity, "utf-8");
                } else {
                    System.out.println("网页内容：" + EntityUtils.toString(response.getEntity(), "utf-8"));
                }
            }else {
                System.out.println("网页内容：" + EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        }
        return null;
    }


    private void init() {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf)
                .register("https", sslsf)
                .build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        // 设置最大连接数
        cm.setMaxTotal(maxTotal);
        // 设置每个路由的默认连接数
        cm.setDefaultMaxPerRoute(defaultMaxPerRoute);

        //连接保持时间
        ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                // Honor 'keep-alive' header
                HeaderElementIterator it = new BasicHeaderElementIterator(
                        response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase("timeout")) {
                        try {
                            return Long.parseLong(value) * 1000;
                        } catch (NumberFormatException ignore) {
                        }
                    }
                }
                return 30 * 1000;
            }
        };

        this.httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler)
                .setKeepAliveStrategy(myStrategy)
                .build();

    }

    /**
     * http头信息的设置
     *
     * @param httpRequestBase
     */
    private void config(HttpRequestBase httpRequestBase) {
        httpRequestBase.setHeader("User-Agent", PublicConstant.UserAgent);
        httpRequestBase.setHeader("Accept", "application/json, text/plain, */*");
        httpRequestBase.setHeader("Connection", "keep-alive");
        httpRequestBase.setHeader("st", PublicConstant.st);
        httpRequestBase.setHeader("tk", PublicConstant.tk);
        httpRequestBase.setHeader("Cookie", PublicConstant.Cookie);
        httpRequestBase.setHeader("content-type", "application/json;charset=utf-8");
        httpRequestBase.setHeader("Connection", "keep-alive");
        httpRequestBase.setHeader("Referer", "https://wx.healthych.com/index.html");
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
        httpRequestBase.setConfig(requestConfig);
    }

    private class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
            return false;
        }
    }


}