package com.haibo.test.model.domain;



/**
 * @author XD
 * @date 2019/2/26 17:22
 */

public class ReturnDate {
    private String code;
    private Data data;
    private boolean ok;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
