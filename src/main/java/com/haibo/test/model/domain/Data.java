package com.haibo.test.model.domain;

import java.util.Date;
import java.util.List;

/**
 * @author XD
 * @date 2019/2/26 17:25
 */

public class Data {
    private List<Date> dateList;
    private int subscribeDays;

    public List<Date> getDateList() {
        return dateList;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }

    public int getSubscribeDays() {
        return subscribeDays;
    }

    public void setSubscribeDays(int subscribeDays) {
        this.subscribeDays = subscribeDays;
    }
}
