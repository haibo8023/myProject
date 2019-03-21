package com.haibo.test.service.impl;

import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author XD
 * @date 2019/1/23 15:54
 */
@Service
public class NonghangServiceImpl {
    private static String getDateUrl = "https://wx.healthych.com/order/subscribe/workDays.do?";
    private static String getDateOrder = "https://wx.healthych.com/order/subscribe/findSubscribeAmountByDays.do?";
    private static String getDateIdUrl = "https://wx.healthych.com/order/subscribe/departmentWorkTimes.do?";
    private static String commiturl = "https://wx.healthych.com/order/subscribe/add.do?";
    private static String getId = "https://wx.healthych.com/base/department/vaccines.do?";
    private static String vaccCode = "8803";
    private static String linkmanId = "489926";
    List<String> strings = Arrays.asList("5101140012");

//    @Scheduled(fixedRate = 10)
    @Test
    public void testMain() throws Exception {
//        SimpleDateFormat sdf = new SimpleDateFormat("ss SSS");
//        Integer departmentVaccineId = null;
//        for (String adress : strings) {
//            String url1 = getId + "depaCode=" + adress + "&vaccineCode=" + vaccCode;
//            String result1 = HttpClientUtil.doGet(url1, null);
//            JSONObject jsStr1 = JSONObject.parseObject(result1);
//            System.out.println(sdf.format(new Date()) + "  :getId" + "____" + adress + jsStr1.toJSONString());
//            JsonRootBean jsonRootBean = JSONObject.toJavaObject(jsStr1, JsonRootBean.class);
//            departmentVaccineId = jsonRootBean.getData().get(0).getId();
//            String url2 = getDateUrl + "depaCode=" + adress + "&linkmanId=" + linkmanId + "&vaccCode=" + vaccCode + "&departmentVaccineId=" + departmentVaccineId + "&vaccineIndex=1";
//            String result2 = HttpClientUtil.doGet(url2, null);
//            JSONObject jsStr2 = JSONObject.parseObject(result2);
//            System.out.println(sdf.format(new Date()) + "  :getDateUrl" + jsStr2.get("data").toString());
//            ReturnDate returnDate = JSONObject.toJavaObject(jsStr2, ReturnDate.class);
//            if (returnDate != null) {
//                if (returnDate.getCode().equals("0000") && returnDate.isOk() && CollectionUtils.isNotEmpty(returnDate.getData().getDateList())) {
//                    List<Date> dateList = returnDate.getData().getDateList();
//                    if (!CollectionUtils.isEmpty(dateList)) {
//                        String url3 = getDateOrder + "depaCode=" + adress + "&vaccCode=" + vaccCode + "&vaccIndex=1&days=" + DateUtil.convertListDate(returnDate.getData().getDateList()) + "&departmentVaccineId=" + departmentVaccineId;
//                        String result3 = HttpClientUtil.doGet(url3, null);
//                        JSONObject jsStr3 = JSONObject.parseObject(result3);
//                        System.out.println(sdf.format(new Date()) + "  :getDateOrder" + jsStr3.get("data").toString());
//                        DateOrder dateOrder = JSONObject.toJavaObject(jsStr3, DateOrder.class);
//                        List<Data3> data3s = dateOrder.getData();
//                        for (Data3 date3 : data3s) {
//                            if (date3.getMaxSub() >0) {
//                                Integer dateId = null;
//                                String dateValue = DateUtil.strToDateFormat(date3.getDay());
//                                String url4 = getDateIdUrl + "depaCode=" + adress + "&vaccCode=" + vaccCode + "&vaccIndex=1&subsribeDate=" + dateValue + "&departmentVaccineId=" + departmentVaccineId + "&linkmanId=" + linkmanId;
//                                String result4 = HttpClientUtil.doGet(url4, null);
//                                JSONObject jsStr4 = JSONObject.parseObject(result4);
//                                System.out.println(sdf.format(new Date()) + "getDateIdUrl" + jsStr4.toJSONString());
//                                ReturnDateId returnDateId = JSONObject.toJavaObject(jsStr4, ReturnDateId.class);
//                                if (returnDateId != null) {
//                                    if (returnDateId.isOk() && returnDateId.getCode().equals("0000")) {
//                                        if (returnDateId.getData() != null && CollectionUtils.isNotEmpty(returnDateId.getData())) {
//                                            List<DateId> dateIds = returnDateId.getData();
//                                            for (DateId dateId1 : dateIds) {
//                                                dateId = dateId1.getId();
//                                                if (null != dateId) {
//                                                    String url5 = commiturl + "depaCode=" + adress + "&vaccineCode=" + vaccCode + "&vaccineIndex=1&linkmanId=545831&subscribeDate=" + dateValue + "&subscirbeTime=" + dateId + "&departmentVaccineId=" + departmentVaccineId;
//                                                    String result5 = HttpClientUtil.doGet(url5, null);
//                                                    JSONObject jsStr5 = JSONObject.parseObject(result5);
//                                                    if (jsStr5 != null) {
//                                                        System.out.println("commiturl--" + jsStr5.toJSONString());
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    } else {
//                        continue;
//                    }
//                }
//            }
//
//        }
//    }
    }
}
