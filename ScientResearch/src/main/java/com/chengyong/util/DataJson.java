package com.chengyong.util;

import java.io.Serializable;

public class DataJson implements Serializable {
    private Short code=0;
    private String msg="";
    private long count;
    private Object data;

    public DataJson(long count,Object data){
      this.count = count;
      this.data = data;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
