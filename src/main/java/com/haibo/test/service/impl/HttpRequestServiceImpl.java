package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.mapper.CustomerMapper;
import com.haibo.test.model.domain.CityInfo;
import com.haibo.test.model.domain.Customer;
import com.haibo.test.model.domain.Message;
import com.haibo.test.model.domain.ResponseVo;
import com.haibo.test.utils.HttpClientUtil;
import com.haibo.test.utils.MailService;
import com.xdbigdata.framework.service.BaseService;
import com.xdbigdata.framework.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XD
 * @date 2018/8/23 12:00
 */
@Slf4j
@Service
public class HttpRequestServiceImpl extends BaseServiceImpl<Customer, CustomerMapper> implements BaseService<Customer, CustomerMapper> {
    @Autowired
    private MailService mailService;
    private HttpClientUtil httpClientUtil = null;
    private HttpClientUtil httpClientUtil1 = null;
    private HttpClientUtil httpClientUtil2 = null;

    @Scheduled(fixedRate = 100)
    public void testMain() throws Exception {
        String url = "https://www.jiyou-tech.com/2018/287/php/get_rank.php";
        String commitUrl = "https://www.jiyou-tech.com/2018/287/php/add_light.php";
        String geocoderUrl = "https://www.jiyou-tech.com/2018/287/php/geocoder.php";
        String charset = "utf-8";
        try {
            httpClientUtil = new HttpClientUtil();
            Map<String, String> createMap = new HashMap<String, String>();
            createMap.put("customer", "0AmYQr_B-Wr3W2J7tArcFIdMk_iLRyuVp9UNa0Fe8xcLUgrsWYVO6wpPAnrVlieb21YacYaSktmiGr2HtgtKYAURsn4G0mU7mTdMFlUNSrlfSTGkWE53SSICXJAdPsGrlxCo2EPcjxji6CIXjhVCLoJwihqhjSQrrnklZdrwVAQ%3D");
            String httpOrgCreateTestRtn = httpClientUtil.doPost(url, createMap, charset);
            JSONObject jsStr = JSONObject.parseObject(httpOrgCreateTestRtn);
            ResponseVo responseVo = (ResponseVo) JSONObject.toJavaObject(jsStr, ResponseVo.class);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            if (null != responseVo && responseVo.getCode().equals(200)) {
                //System.out.println(sdf.format(new Date()) + responseVo.toString());
                List<CityInfo> cityInfoList = responseVo.getRanks();
                for (CityInfo cityInfo : cityInfoList) {
                    if (useCommit(cityInfo.getTotal())) {
                        httpClientUtil2 = new HttpClientUtil();
                        Map<String, String> map2 = new HashMap<String, String>();
                        Customer customer = new Customer();
                        customer.setCity(cityInfo.getCity());
                        Customer selectOne = mapper.selectOne(customer);
                        map2.put("lat", selectOne.getLatitude());
                        map2.put("long", selectOne.getLongitude());
                        map2.put("customer", selectOne.getCustomer());
                        String rtncode = httpClientUtil2.doPost(geocoderUrl, map2, "utf-8");
                        JSONObject rtnobject = JSONObject.parseObject(rtncode);
                        log.warn(cityInfo.toString() + "定位结果通知", rtnobject.toString());
                        mailService.sendHtmlMail("15756308704@139.com", "定位结果通知", rtnobject.toString());
                        httpClientUtil1 = new HttpClientUtil();
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("nick", "bu661");
                        map.put("customer", selectOne.getCustomer());
                        String rtn = httpClientUtil1.doPost(commitUrl, map, "utf-8");
                        JSONObject jsonObject = JSONObject.parseObject(rtn);
                        Message response = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
                        log.warn("点亮结果:" + response.toString());
                        MailService.sendHtmlMail("15756308704@139.com", "点亮结果通知", response.toString());
                    }
                    if (testPrint(cityInfo.getTotal())) {
                        System.out.println(sdf.format(new Date()) + cityInfo.toString());
                        //mailService.sendHtmlMail("15756308704@139.com", "准备", cityInfo.toString());
                    }
                    if (useLoop(cityInfo.getTotal())) {
                        log.warn("通知，城市:" + cityInfo.getCity() + cityInfo.getTotal());
                        mailService.sendHtmlMail("15756308704@139.com", "通知，城市:" + cityInfo.getCity(), cityInfo.getCity() + cityInfo.getTotal());
                    }
                }
            } else {
                System.out.println(sdf.format(new Date()) + "请求主机失败");
                log.error(sdf.format(new Date()) + "请求主机失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //使用循环判断
    public static boolean useLoop(String targetValue) {
        String[] array = {"86", "87", "886", "887", "8886", "8887", "88886", "88887", "888886", "888887"};
        for (String s : array) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    //使用循环判断
    public static boolean useCommit(String targetValue) {
        String[] array = {"87", "887", "8887", "88887", "888887"};
        for (String s : array) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    //使用循环判断
    public static boolean testPrint(String targetValue) {
        Integer value = Integer.parseInt(targetValue);
        if (value >= 85 && value < 88) {
            return true;
        }
        if (value >= 885 && value < 888) {
            return true;
        }
        if (value >= 8885 && value < 8888) {
            return true;
        }
        if (value >= 88885 && value < 88888) {
            return true;
        }
        if (value >= 888885 && value < 888888) {
            return true;
        }
        return false;
    }

    public static void playSound() throws MalformedURLException, FileNotFoundException, InterruptedException {
        //选择播放文件
        File file = new File("D:\\guangData\\src\\main\\resources\\f1.WAV");
        //创建audioclip对象
        AudioClip audioClip = null;
        //将file转换为url
        audioClip = Applet.newAudioClip(file.toURL());
        //循环播放	播放一次可以使用audioClip.play
        audioClip.loop();
    }
}
