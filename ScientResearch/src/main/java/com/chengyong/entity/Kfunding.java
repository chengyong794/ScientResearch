package com.chengyong.entity;

public class Kfunding {
    private Short jid;

    private String pname;

    private String pcname;

    private String members;

    private String pccome;

    private String pcclasify;

    private String pdept;

    private String jsubdate;

    private Double jamount;

    private Double totalfund;

    private Double distri;

    private Short kyid;

    private Integer page;

    private Integer limit;

    public Short getKyid() {
        return kyid;
    }

    public void setKyid(Short kyid) {
        this.kyid = kyid;
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

    public Double getDistri() {
        return distri;
    }

    public void setDistri(Double distri) {
        this.distri = distri;
    }

    public Double getTotalfund() {
        return totalfund;
    }

    public void setTotalfund(Double totalfund) {
        this.totalfund = totalfund;
    }

    public Short getJid() {
        return jid;
    }

    public void setJid(Short jid) {
        this.jid = jid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
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

    public String getPdept() {
        return pdept;
    }

    public void setPdept(String pdept) {
        this.pdept = pdept;
    }

    public String getJsubdate() {
        return jsubdate;
    }

    public void setJsubdate(String jsubdate) {
        this.jsubdate = jsubdate;
    }

    public Double getJamount() {
        return jamount;
    }

    public void setJamount(Double jamount) {
        this.jamount = jamount;
    }
}