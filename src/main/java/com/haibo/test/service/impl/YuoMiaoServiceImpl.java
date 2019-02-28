package com.haibo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.test.model.domain.ReturnDate;
import com.haibo.test.model.vo.JsonRootBean;
import com.haibo.test.utils.HttpClientUtil;
import com.xdbigdata.framework.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Slf4j
@Service
public class YuoMiaoServiceImpl {
    private static String getDateUrl = "https://wx.healthych.com/order/subscribe/workDays.do?";
    private static String getDateIdUrl = "https://wx.healthych.com/order/subscribe/departmentWorkTimes.do?";
    private static String commiturl = "https://wx.healthych.com/order/subscribe/add.do?";
    private static String getId = "https://wx.healthych.com/base/department/vaccines.do?";
    List<String> strings = Arrays.asList("5106030011", "5106030008", "5106030009", "5106030013", "5106030010", "5106030012", "5106030007");

//    @Scheduled(cron = "59 59 14 * * ? ")
    @Test
    public void testMain() throws Exception {
        for (int i = 0; i < 1; i++) {
            Integer departmentVaccineId = null;
            for (String adress : strings) {
                String url4 = getId + "depaCode=" + adress + "&vaccCode=8803";
                String result4 = HttpClientUtil.doGet(url4, null);
                JSONObject jsStr4 = JSONObject.parseObject(result4);
                JsonRootBean jsonRootBean = JSONObject.toJavaObject(jsStr4, JsonRootBean.class);
                departmentVaccineId = jsonRootBean.getData().get(0).getId();
                String url1 = getDateUrl + "depaCode=" + adress + "&vaccCode=8803&departmentVaccineId=" + departmentVaccineId + "&vaccineIndex=1";
                String result1 = HttpClientUtil.doGet(url1, null);
                JSONObject jsStr1 = JSONObject.parseObject(result1);
                System.out.println(url1);
                System.out.println(jsStr1.toJSONString());
                ReturnDate returnDate = JSONObject.toJavaObject(jsStr1, ReturnDate.class);
                if (returnDate != null) {
                    if (returnDate.getCode().equals("0000") && returnDate.isOk() && CollectionUtils.isNotEmpty(returnDate.getData().getDateList())) {
                        List<Date> dateList = returnDate.getData().getDateList();
                        if (!CollectionUtils.isEmpty(dateList)) {
                            Collections.reverse(dateList);
                            for (Date date : dateList) {
                                String dateValue = DateUtils.formatShortDate(date);
                                String url3 = commiturl + "depaCode=" + adress + "&vaccineCode=8803&vaccineIndex=1&linkmanId=545831&subscribeDate=" + dateValue + "&departmentVaccineId=" + departmentVaccineId;
                                String result3 = HttpClientUtil.doGet(url3, null);
                                JSONObject jsStr3 = JSONObject.parseObject(result3);
                                if (jsStr3 != null) {
                                    System.out.println(url3);
                                    System.out.println(jsStr3.toJSONString());
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }

            }
        }
    }
}
