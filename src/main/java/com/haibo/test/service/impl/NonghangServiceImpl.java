package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.model.domain.ReturnDate;
import com.haibo.test.model.domain.ReturnDateId;
import com.haibo.test.utils.HttpClientUtil;
import com.xdbigdata.framework.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Slf4j
@Service
public class NonghangServiceImpl {
    private static String getDateUrl = "https://wx.healthych.com/order/subscribe/workDays.do?";
    private static String getDateIdUrl = "https://wx.healthych.com/order/subscribe/departmentWorkTimes.do?";
    private static String commiturl = "https://wx.healthych.com/order/subscribe/add.do?";
    List<String> strings = Arrays.asList("5101850004", "5101850005", "5101850006");

    @Scheduled(cron = "59 59 14 * * ? ")
    public void testMain() throws Exception {
        for (int i = 0; i < 100000000; i++) {
            String departmentVaccineId = null;
            for (String adress : strings) {
                if (adress.equals("5101850004")) {
                    departmentVaccineId = "3578";
                } else if (adress.equals("5101850005")) {
                    departmentVaccineId = "3577";
                } else {
                    departmentVaccineId = "3587";
                }
                String url1 = getDateUrl + "depaCode=" + adress + "&vaccCode=8803&departmentVaccineId=" + departmentVaccineId + "&vaccineIndex=1";
                String result1 = HttpClientUtil.doGet(url1, null);
                JSONObject jsStr1 = JSONObject.parseObject(result1);
                ReturnDate returnDate = JSONObject.toJavaObject(jsStr1, ReturnDate.class);
                if (returnDate != null) {
                    if (returnDate.getCode().equals("0000") && returnDate.isOk() && CollectionUtils.isNotEmpty(returnDate.getData().getDateList())) {
                        List<Date> dateList = returnDate.getData().getDateList();
                        for (Date date : dateList) {
                            Integer dateId = null;
                            String dateValue = DateUtils.formatShortDate(date);
                            String url2 = getDateIdUrl + "depaCode=" + adress + "&vaccCode=8803&vaccIndex=1&subsribeDate=" + dateValue + "&departmentVaccineId=" + departmentVaccineId + "&linkmanId=545831";
                            String result2 = HttpClientUtil.doGet(url2, null);
                            JSONObject jsStr2 = JSONObject.parseObject(result2);
                            ReturnDateId returnDateId = JSONObject.toJavaObject(jsStr2, ReturnDateId.class);
                            if (returnDateId != null) {
                                if (returnDateId.getOk() && returnDateId.getCode().equals("0000")) {
                                    dateId = returnDateId.getData().get(0).getId();
                                    String url3 =commiturl+ "depaCode=" + adress + "&vaccineCode=8803&vaccineIndex=1&linkmanId=545831&subscribeDate=" + dateValue + "&subscirbeTime=" + dateId + "&departmentVaccineId=" + departmentVaccineId;
                                    String result3 = HttpClientUtil.doGet(url3, null);
                                    JSONObject jsStr3 = JSONObject.parseObject(result3);
                                    if (jsStr3 != null) {
                                        System.out.println(jsStr3.toJSONString());
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
