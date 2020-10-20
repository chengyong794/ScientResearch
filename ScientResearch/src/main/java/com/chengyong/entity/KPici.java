package com.chengyong.entity;

import java.io.Serializable;

public class KPici implements Serializable {
    private Short pcid;

    private String pcname;

    private String pcstate;

    private String pccome;

    private String pcclasify;

    private String pcdescribe;

    private String pcstarttime;

    private String pcendtime;

    private Integer page;

    private Integer limit;

    public String getPcdescribe() {
        return pcdescribe;
    }

    public void setPcdescribe(String pcdescribe) {
        this.pcdescribe = pcdescribe;
    }

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

    public String getPcstarttime() {
        return pcstarttime;
    }

    public void setPcstarttime(String pcstarttime) {
        this.pcstarttime = pcstarttime;
    }

    public String getPcendtime() {
        return pcendtime;
    }

    public void setPcendtime(String pcendtime) {
        this.pcendtime = pcendtime;
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
}