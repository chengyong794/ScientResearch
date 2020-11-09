package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KThesis implements Serializable {
    private Short tid;

    private String tname;

    private String tjob;

    private String tdept;

    private String ttitle;

    private String tperiodical;

    private String tcnid;

    private String tissnid;

    private String tstarttime;

    private String tothers;

    private String tscore;

    private String tremaks;

    private String tsecond;

    private String tthird;

    private Short tachnum;

    private String tmembers;

    private Short kyid;

    private String tresource;

    private Integer page;

    private Integer limit;

    public String getTresource() {
        return tresource;
    }

    public void setTresource(String tresource) {
        this.tresource = tresource;
    }

    public Short getKyid() {
        return kyid;
    }

    public void setKyid(Short kyid) {
        this.kyid = kyid;
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

    public Short getTid() {
        return tid;
    }

    public void setTid(Short tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTjob() {
        return tjob;
    }

    public void setTjob(String tjob) {
        this.tjob = tjob;
    }

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public String getTperiodical() {
        return tperiodical;
    }

    public void setTperiodical(String tperiodical) {
        this.tperiodical = tperiodical;
    }

    public String getTcnid() {
        return tcnid;
    }

    public void setTcnid(String tcnid) {
        this.tcnid = tcnid;
    }

    public String getTissnid() {
        return tissnid;
    }

    public void setTissnid(String tissnid) {
        this.tissnid = tissnid;
    }

    public String getTstarttime() {
        return tstarttime;
    }

    public void setTstarttime(String tstarttime) {
        this.tstarttime = tstarttime;
    }

    public String getTothers() {
        return tothers;
    }

    public void setTothers(String tothers) {
        this.tothers = tothers;
    }

    public String getTscore() {
        return tscore;
    }

    public void setTscore(String tscore) {
        this.tscore = tscore;
    }

    public String getTremaks() {
        return tremaks;
    }

    public void setTremaks(String tremaks) {
        this.tremaks = tremaks;
    }

    public String getTsecond() {
        return tsecond;
    }

    public void setTsecond(String tsecond) {
        this.tsecond = tsecond;
    }

    public String getTthird() {
        return tthird;
    }

    public void setTthird(String tthird) {
        this.tthird = tthird;
    }

    public Short getTachnum() {
        return tachnum;
    }

    public void setTachnum(Short tachnum) {
        this.tachnum = tachnum;
    }

    public String getTmembers() {
        return tmembers;
    }

    public void setTmembers(String tmembers) {
        this.tmembers = tmembers;
    }
}