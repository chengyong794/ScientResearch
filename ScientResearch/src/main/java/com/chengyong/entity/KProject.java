package com.chengyong.entity;

import java.util.Date;

public class KProject {
    private Short pid;

    private String pname;

    private String pcoms;

    private String ppeople;

    private String ptype;

    private String pdept;

    private String psource;

    private String pothers;

    private Date pdate;

    private Date pstarttime;

    private Date pendtime;

    public Short getPid() {
        return pid;
    }

    public void setPid(Short pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcoms() {
        return pcoms;
    }

    public void setPcoms(String pcoms) {
        this.pcoms = pcoms;
    }

    public String getPpeople() {
        return ppeople;
    }

    public void setPpeople(String ppeople) {
        this.ppeople = ppeople;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
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

    public String getPothers() {
        return pothers;
    }

    public void setPothers(String pothers) {
        this.pothers = pothers;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Date getPstarttime() {
        return pstarttime;
    }

    public void setPstarttime(Date pstarttime) {
        this.pstarttime = pstarttime;
    }

    public Date getPendtime() {
        return pendtime;
    }

    public void setPendtime(Date pendtime) {
        this.pendtime = pendtime;
    }
}