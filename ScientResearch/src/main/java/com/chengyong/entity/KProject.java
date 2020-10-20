package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KProject implements Serializable {
    private Short pid;

    private String pname;

    private String pccome;

    private String ppeople;

    private String pcclasify;

    private String pdept;

    private String psource;

    private String pothers;

     private String presfrom;

    private String pdate;

    private String pendtime;

    public String getPresfrom() {
        return presfrom;
    }

    public void setPresfrom(String presfrom) {
        this.presfrom = presfrom;
    }

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

    public String getPccome() {
        return pccome;
    }

    public void setPccome(String pccome) {
        this.pccome = pccome;
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

    public String getPothers() {
        return pothers;
    }

    public void setPothers(String pothers) {
        this.pothers = pothers;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPendtime() {
        return pendtime;
    }

    public void setPendtime(String pendtime) {
        this.pendtime = pendtime;
    }
}