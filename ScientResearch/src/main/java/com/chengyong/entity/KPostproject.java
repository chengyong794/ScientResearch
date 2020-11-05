package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KPostproject extends KProject {
    private Short ppid;

    private Short pid;

    private String ppname;

    private String ppnum;

    private String pppeople;

    private String ppcontrol;

    private Short ppstate1;

    private Short ppstate2;

    private String ppstate3;

    private String ppcome;

    private String pptype;

    private String ppdept;

    private String ppstarttime;

    private String ppendtime;

    private String ppadjuct;

    private String ppform;

    private String ppstatus;

    private String ppremak;

    private String subtime;

    private Integer page;

    private Integer limit;

    @Override
    public Short getPid() {
        return pid;
    }

    @Override
    public void setPid(Short pid) {
        this.pid = pid;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Short getPpid() {
        return ppid;
    }

    public void setPpid(Short ppid) {
        this.ppid = ppid;
    }

    public String getPpname() {
        return ppname;
    }

    public void setPpname(String ppname) {
        this.ppname = ppname;
    }

    public String getPpnum() {
        return ppnum;
    }

    public void setPpnum(String ppnum) {
        this.ppnum = ppnum;
    }

    public String getPppeople() {
        return pppeople;
    }

    public void setPppeople(String pppeople) {
        this.pppeople = pppeople;
    }

    public String getPpcontrol() {
        return ppcontrol;
    }

    public void setPpcontrol(String ppcontrol) {
        this.ppcontrol = ppcontrol;
    }

    public Short getPpstate1() {
        return ppstate1;
    }

    public void setPpstate1(Short ppstate1) {
        this.ppstate1 = ppstate1;
    }

    public Short getPpstate2() {
        return ppstate2;
    }

    public void setPpstate2(Short ppstate2) {
        this.ppstate2 = ppstate2;
    }

    public String getPpstate3() {
        return ppstate3;
    }

    public void setPpstate3(String ppstate3) {
        this.ppstate3 = ppstate3;
    }

    public String getPpcome() {
        return ppcome;
    }

    public void setPpcome(String ppcome) {
        this.ppcome = ppcome;
    }

    public String getPptype() {
        return pptype;
    }

    public void setPptype(String pptype) {
        this.pptype = pptype;
    }

    public String getPpdept() {
        return ppdept;
    }

    public void setPpdept(String ppdept) {
        this.ppdept = ppdept;
    }

    public String getPpstarttime() {
        return ppstarttime;
    }

    public void setPpstarttime(String ppstarttime) {
        this.ppstarttime = ppstarttime;
    }

    public String getPpendtime() {
        return ppendtime;
    }

    public void setPpendtime(String ppendtime) {
        this.ppendtime = ppendtime;
    }

    public String getSubtime() {
        return subtime;
    }

    public void setSubtime(String subtime) {
        this.subtime = subtime;
    }

    public String getPpadjuct() {
        return ppadjuct;
    }

    public void setPpadjuct(String ppadjuct) {
        this.ppadjuct = ppadjuct;
    }

    public String getPpform() {
        return ppform;
    }

    public void setPpform(String ppform) {
        this.ppform = ppform;
    }

    public String getPpstatus() {
        return ppstatus;
    }

    public void setPpstatus(String ppstatus) {
        this.ppstatus = ppstatus;
    }

    public String getPpremak() {
        return ppremak;
    }

    public void setPpremak(String ppremak) {
        this.ppremak = ppremak;
    }
}