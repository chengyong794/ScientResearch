package com.chengyong.entity;

import java.io.Serializable;

public class KProjectper implements Serializable {
    private Short pperid;

    private String ppername;

    private Short pid;

    private String unitname;

    private Short pperwork;

    private String ppertype;

    public Short getPperid() {
        return pperid;
    }

    public void setPperid(Short pperid) {
        this.pperid = pperid;
    }

    public String getPpername() {
        return ppername;
    }

    public void setPpername(String ppername) {
        this.ppername = ppername;
    }

    public Short getPid() {
        return pid;
    }

    public void setPid(Short pid) {
        this.pid = pid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public Short getPperwork() {
        return pperwork;
    }

    public void setPperwork(Short pperwork) {
        this.pperwork = pperwork;
    }

    public String getPpertype() {
        return ppertype;
    }

    public void setPpertype(String ppertype) {
        this.ppertype = ppertype;
    }
}