package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KNotice implements Serializable {
    private Short nid;

    private String ncontext;

    private String nperson;

    private String nstarttime;

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

    public String getNstarttime() {
        return nstarttime;
    }

    public void setNstarttime(String nstarttime) {
        this.nstarttime = nstarttime;
    }
}