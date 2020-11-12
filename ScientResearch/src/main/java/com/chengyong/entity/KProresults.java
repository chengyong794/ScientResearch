package com.chengyong.entity;

import com.chengyong.util.personYear;

import java.io.Serializable;
import java.util.Date;

public class KProresults extends personYear implements Serializable {
    private Short prid;

    private String prname;

    private String prjob;

    private String prdept;

    private String prtitle;

    private String dept;

    private String prendid;

    private String prstarttime;

    private String prothers;

    private String prscore;

    private String prremarks;

    private String prsecond;

    private String prthird;

    private Short prachnum;

    private String prmembers;

    private Short kyid;

    private String presource;

    private Integer page;

    private Integer limit;

    public void setPrstarttime(String prstarttime) {
        this.prstarttime = prstarttime;
    }

    public void setPrachnum(Short prachnum) {
        this.prachnum = prachnum;
    }

    public Short getKyid() {
        return kyid;
    }

    public void setKyid(Short kyid) {
        this.kyid = kyid;
    }

    public String getPresource() {
        return presource;
    }

    public void setPresource(String presource) {
        this.presource = presource;
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

    public Short getPrid() {
        return prid;
    }

    public void setPrid(Short prid) {
        this.prid = prid;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getPrjob() {
        return prjob;
    }

    public void setPrjob(String prjob) {
        this.prjob = prjob;
    }

    public String getPrdept() {
        return prdept;
    }

    public void setPrdept(String prdept) {
        this.prdept = prdept;
    }

    public String getPrtitle() {
        return prtitle;
    }

    public void setPrtitle(String prtitle) {
        this.prtitle = prtitle;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPrstarttime() {
        return prstarttime;
    }

    public Short getPrachnum() {
        return prachnum;
    }

    public String getPrendid() {
        return prendid;
    }

    public void setPrendid(String prendid) {
        this.prendid = prendid;
    }

    public String getProthers() {
        return prothers;
    }

    public void setProthers(String prothers) {
        this.prothers = prothers;
    }

    public String getPrscore() {
        return prscore;
    }

    public void setPrscore(String prscore) {
        this.prscore = prscore;
    }

    public String getPrremarks() {
        return prremarks;
    }

    public void setPrremarks(String prremarks) {
        this.prremarks = prremarks;
    }

    public String getPrsecond() {
        return prsecond;
    }

    public void setPrsecond(String prsecond) {
        this.prsecond = prsecond;
    }

    public String getPrthird() {
        return prthird;
    }

    public void setPrthird(String prthird) {
        this.prthird = prthird;
    }

    public String getPrmembers() {
        return prmembers;
    }

    public void setPrmembers(String prmembers) {
        this.prmembers = prmembers;
    }
}