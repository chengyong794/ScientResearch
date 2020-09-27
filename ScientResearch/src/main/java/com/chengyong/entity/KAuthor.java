package com.chengyong.entity;

import java.io.Serializable;

public class KAuthor implements Serializable {
    private Short aid;

    private String aname;

    private String ajob;

    private String adept;

    public Short getAid() {
        return aid;
    }

    public void setAid(Short aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAjob() {
        return ajob;
    }

    public void setAjob(String ajob) {
        this.ajob = ajob;
    }

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept;
    }
}