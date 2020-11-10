package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KWork implements Serializable {
    private Short wid;

    private String wname;

    private String wjob;

    private String wdept;

    private String wtitle;

    private String wpublish;

    private String wisbnid;

    private String wstarttime;

    private String wothers;

    private String wscore;

    private String wremarks;

    private String wsecond;

    private String wthird;

    private Short wachnum;

    private String wmembers;

    private Short kyid;

    private String wresource;

    private Integer page;

    private Integer limit;

    public void setWachnum(Short wachnum) {
        this.wachnum = wachnum;
    }

    public Short getKyid() {
        return kyid;
    }

    public void setKyid(Short kyid) {
        this.kyid = kyid;
    }

    public String getWresource() {
        return wresource;
    }

    public void setWresource(String wresource) {
        this.wresource = wresource;
    }

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

    public Short getWid() {
        return wid;
    }

    public void setWid(Short wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWjob() {
        return wjob;
    }

    public void setWjob(String wjob) {
        this.wjob = wjob;
    }

    public String getWdept() {
        return wdept;
    }

    public void setWdept(String wdept) {
        this.wdept = wdept;
    }

    public String getWtitle() {
        return wtitle;
    }

    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }

    public String getWpublish() {
        return wpublish;
    }

    public void setWpublish(String wpublish) {
        this.wpublish = wpublish;
    }

    public String getWisbnid() {
        return wisbnid;
    }

    public void setWisbnid(String wisbnid) {
        this.wisbnid = wisbnid;
    }

    public String getWstarttime() {
        return wstarttime;
    }

    public void setWstarttime(String wstarttime) {
        this.wstarttime = wstarttime;
    }

    public Short getWachnum() {
        return wachnum;
    }

    public String getWothers() {
        return wothers;
    }

    public void setWothers(String wothers) {
        this.wothers = wothers;
    }

    public String getWscore() {
        return wscore;
    }

    public void setWscore(String wscore) {
        this.wscore = wscore;
    }

    public String getWremarks() {
        return wremarks;
    }

    public void setWremarks(String wremarks) {
        this.wremarks = wremarks;
    }

    public String getWsecond() {
        return wsecond;
    }

    public void setWsecond(String wsecond) {
        this.wsecond = wsecond;
    }

    public String getWthird() {
        return wthird;
    }

    public void setWthird(String wthird) {
        this.wthird = wthird;
    }

    public String getWmembers() {
        return wmembers;
    }

    public void setWmembers(String wmembers) {
        this.wmembers = wmembers;
    }
}