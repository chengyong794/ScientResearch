package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KInfo implements Serializable {
    private Short iid;

    private String outperson;

    private String infoperson;

    private String icontext;

    private String iatta;

    private String infotime;

    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setInfotime(String infotime) {
        this.infotime = infotime;
    }

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

    public String getInfotime() {
        return infotime;
    }
}