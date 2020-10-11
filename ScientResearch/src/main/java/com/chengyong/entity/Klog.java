package com.chengyong.entity;

import com.chengyong.util.Klog_Str;

import java.io.Serializable;
import java.util.Date;

public class Klog extends Klog_Str implements Serializable {
    private Short logId;
    private String username;
    private String userip;
    private String logintime;


    public Short getLogId() {
        return logId;
    }

    public void setLogId(Short logId) {
        this.logId = logId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }
}
