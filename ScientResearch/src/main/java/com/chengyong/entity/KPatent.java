package com.chengyong.entity;

import com.chengyong.util.personYear;

import java.io.Serializable;
import java.util.Date;

public class KPatent extends personYear implements Serializable {
    private Short zid;

    private String zname;

    private String pjob;

    private String zdept;

    private String patentname;

    private String ztype;

    private String zranid;

    private String zstate;

    private String znum;

    private String zdate;

    private String zaward;

    private String zothers;

    private String zscore;

    private String zremarks;

    private String zsecond;

    private String zthird;

    private Short zachnum;

    private String zmembers;

    private Short kyid;

    private String zresource;

    private Integer page;

    private Integer limit;

    public String getZdate() {
        return zdate;
    }

    public void setZdate(String zdate) {
        this.zdate = zdate;
    }

    public Short getZachnum() {
        return zachnum;
    }

    public void setZachnum(Short zachnum) {
        this.zachnum = zachnum;
    }

    public Short getKyid() {
        return kyid;
    }

    public void setKyid(Short kyid) {
        this.kyid = kyid;
    }

    public String getZresource() {
        return zresource;
    }

    public void setZresource(String zresource) {
        this.zresource = zresource;
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

    public Short getZid() {
        return zid;
    }

    public void setZid(Short zid) {
        this.zid = zid;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public String getPjob() {
        return pjob;
    }

    public void setPjob(String pjob) {
        this.pjob = pjob;
    }

    public String getZdept() {
        return zdept;
    }

    public void setZdept(String zdept) {
        this.zdept = zdept;
    }

    public String getPatentname() {
        return patentname;
    }

    public void setPatentname(String patentname) {
        this.patentname = patentname;
    }

    public String getZtype() {
        return ztype;
    }

    public void setZtype(String ztype) {
        this.ztype = ztype;
    }

    public String getZranid() {
        return zranid;
    }

    public void setZranid(String zranid) {
        this.zranid = zranid;
    }

    public String getZstate() {
        return zstate;
    }

    public void setZstate(String zstate) {
        this.zstate = zstate;
    }

    public String getZnum() {
        return znum;
    }

    public void setZnum(String znum) {
        this.znum = znum;
    }

    public String getZaward() {
        return zaward;
    }

    public void setZaward(String zaward) {
        this.zaward = zaward;
    }

    public String getZothers() {
        return zothers;
    }

    public void setZothers(String zothers) {
        this.zothers = zothers;
    }

    public String getZscore() {
        return zscore;
    }

    public void setZscore(String zscore) {
        this.zscore = zscore;
    }

    public String getZremarks() {
        return zremarks;
    }

    public void setZremarks(String zremarks) {
        this.zremarks = zremarks;
    }

    public String getZsecond() {
        return zsecond;
    }

    public void setZsecond(String zsecond) {
        this.zsecond = zsecond;
    }

    public String getZthird() {
        return zthird;
    }

    public void setZthird(String zthird) {
        this.zthird = zthird;
    }

    public String getZmembers() {
        return zmembers;
    }

    public void setZmembers(String zmembers) {
        this.zmembers = zmembers;
    }
}