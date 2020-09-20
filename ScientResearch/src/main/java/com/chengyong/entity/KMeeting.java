package com.chengyong.entity;

import java.util.Date;

public class KMeeting {
    private Short mid;

    private String mname;

    private String mtype;

    private Date mstarttime;

    private Date mendtime;

    private String mcourname;

    private String maddress;

    private String courtype;

    public Short getMid() {
        return mid;
    }

    public void setMid(Short mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public Date getMstarttime() {
        return mstarttime;
    }

    public void setMstarttime(Date mstarttime) {
        this.mstarttime = mstarttime;
    }

    public Date getMendtime() {
        return mendtime;
    }

    public void setMendtime(Date mendtime) {
        this.mendtime = mendtime;
    }

    public String getMcourname() {
        return mcourname;
    }

    public void setMcourname(String mcourname) {
        this.mcourname = mcourname;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }

    public String getCourtype() {
        return courtype;
    }

    public void setCourtype(String courtype) {
        this.courtype = courtype;
    }
}