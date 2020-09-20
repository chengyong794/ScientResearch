package com.chengyong.entity;

import java.util.Date;

public class KInfo {
    private Short iid;

    private String outperson;

    private String infoperson;

    private String icontext;

    private String iatta;

    private Date infotime;

    public Short getIid() {
        return iid;
    }

    public void setIid(Short iid) {
        this.iid = iid;
    }

    public String getOutperson() {
        return outperson;
    }

    public void setOutperson(String outperson) {
        this.outperson = outperson;
    }

    public String getInfoperson() {
        return infoperson;
    }

    public void setInfoperson(String infoperson) {
        this.infoperson = infoperson;
    }

    public String getIcontext() {
        return icontext;
    }

    public void setIcontext(String icontext) {
        this.icontext = icontext;
    }

    public String getIatta() {
        return iatta;
    }

    public void setIatta(String iatta) {
        this.iatta = iatta;
    }

    public Date getInfotime() {
        return infotime;
    }

    public void setInfotime(Date infotime) {
        this.infotime = infotime;
    }
}