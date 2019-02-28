package com.haibo.test.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author XD
 * @date 2019/2/28 16:18
 */
public class DateUtil {

    public static String convertListDate(List<Date> list) {
// 将List集合中的字符串格式化
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
        // new一个新的集合，来存放格式化的时间数据
        List<String> trend_date = new ArrayList<String>();
        // 将List中的Date集合全部格式化类型为"yy-MM-dd HH:mm"
        for (Date time : list) {
            trend_date.add(simple.format(time).toString());
        }
        return StringUtils.join(trend_date.toArray(), ",");
    }
    public static String strToDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate= formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }
}
