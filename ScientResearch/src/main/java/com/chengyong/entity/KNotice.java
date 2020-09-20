package com.chengyong.entity;

import java.util.Date;

public class KNotice {
    private Short nid;

    private String ncontext;

    private String nperson;

    private Date nstarttime;

    public Short getNid() {
        return nid;
    }

    public void setNid(Short nid) {
        this.nid = nid;
    }

    public String getNcontext() {
        return ncontext;
    }

    public void setNcontext(String ncontext) {
        this.ncontext = ncontext;
    }

    public String getNperson() {
        return nperson;
    }

    public void setNperson(String nperson) {
        this.nperson = nperson;
    }

    public Date getNstarttime() {
        return nstarttime;
    }

    public void setNstarttime(Date nstarttime) {
        this.nstarttime = nstarttime;
    }
}