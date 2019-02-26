/**
  * Copyright 2019 bejson.com 
  */
package com.haibo.test.model.domain;
import java.util.List;

/**
 * Auto-generated: 2019-02-26 17:50:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ReturnDateId {

    private String code;
    private List<DateId> data;
    private boolean ok;
    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setData(List<DateId> data) {
         this.data = data;
     }
     public List<DateId> getData() {
         return data;
     }

    public void setOk(boolean ok) {
         this.ok = ok;
     }
     public boolean getOk() {
         return ok;
     }

}