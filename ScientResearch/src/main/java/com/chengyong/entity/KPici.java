package com.chengyong.entity;

import java.io.Serializable;
import java.util.Date;

public class KPici implements Serializable {
    private Short pcid;

    private String pcname;

    private String pcstate;

    private String pccome;

    private String pcclasify;

    private Date pcstarttime;

    private Date pcendtime;

    public Short getPcid() {
        return pcid;
    }

    public void setPcid(Short pcid) {
        this.pcid = pcid;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public String getPcstate() {
        return pcstate;
    }

    public void setPcstate(String pcstate) {
        this.pcstate = pcstate;
    }

    public String getPccome() {
        return pccome;
    }

    public void setPccome(String pccome) {
        this.pccome = pccome;
    }

    public String getPcclasify() {
        return pcclasify;
    }

    public void setPcclasify(String pcclasify) {
        this.pcclasify = pcclasify;
    }

    public Date getPcstarttime() {
        return pcstarttime;
    }

    public void setPcstarttime(Date pcstarttime) {
        this.pcstarttime = pcstarttime;
    }

    public Date getPcendtime() {
        return pcendtime;
    }

    public void setPcendtime(Date pcendtime) {
        this.pcendtime = pcendtime;
    }
}