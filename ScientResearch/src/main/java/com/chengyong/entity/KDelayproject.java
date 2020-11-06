package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KDelayproject implements Serializable {
    private Short pdelayid;

    private String pname;

    private String ppeople;

    private String pcclasify;

    private String pdept;

    private String psource;

    private String pmark;

    private String pdelaydate;

    private String pdelayendtime;

    private Short pid;

    private Short pyq1;

    private Short pyq2;

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

    public Short getPdelayid() {
        return pdelayid;
    }

    public void setPdelayid(Short pdelayid) {
        this.pdelayid = pdelayid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPpeople() {
        return ppeople;
    }

    public void setPpeople(String ppeople) {
        this.ppeople = ppeople;
    }

    public String getPcclasify() {
        return pcclasify;
    }

    public void setPcclasify(String pcclasify) {
        this.pcclasify = pcclasify;
    }

    public String getPdept() {
        return pdept;
    }

    public void setPdept(String pdept) {
        this.pdept = pdept;
    }

    public String getPsource() {
        return psource;
    }

    public void setPsource(String psource) {
        this.psource = psource;
    }

    public String getPmark() {
        return pmark;
    }

    public void setPmark(String pmark) {
        this.pmark = pmark;
    }

    public String getPdelaydate() {
        return pdelaydate;
    }

    public void setPdelaydate(String pdelaydate) {
        this.pdelaydate = pdelaydate;
    }

    public String getPdelayendtime() {
        return pdelayendtime;
    }

    public void setPdelayendtime(String pdelayendtime) {
        this.pdelayendtime = pdelayendtime;
    }

    public Short getPid() {
        return pid;
    }

    public void setPid(Short pid) {
        this.pid = pid;
    }

    public Short getPyq1() {
        return pyq1;
    }

    public void setPyq1(Short pyq1) {
        this.pyq1 = pyq1;
    }

    public Short getPyq2() {
        return pyq2;
    }

    public void setPyq2(Short pyq2) {
        this.pyq2 = pyq2;
    }
}