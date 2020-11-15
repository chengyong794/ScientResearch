package com.chengyong.util;

public class LoginJson {
    private Integer code;
    private String msg;
    private String url;

    public LoginJson(Integer code, String msg, String url) {
        this.code = code;
        this.msg = msg;
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
