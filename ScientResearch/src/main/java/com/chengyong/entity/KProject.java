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
    private String pzjsource;

    private String pothers;

     private String presfrom;

    private String pdate;

    private String pendtime;

    private Short psb1 ;
    private Short psb2 ;

    private Short plx1 ;
    private Short plx2 ;

    private Short pjx1 ;
    private Short pjx2 ;

    private Short pzj1 ;
    private Short pzj2 ;

    private Short pyq1 ;
    private Short pyq2 ;

    private String members;

    private String pcname;

    private Integer page;

    private Integer limit;

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

    public String getPzjsource() {
        return pzjsource;
    }

    public void setPzjsource(String pzjsource) {
        this.pzjsource = pzjsource;
    }

    public Short getPzj1() {
        return pzj1;
    }

    public void setPzj1(Short pzj1) {
        this.pzj1 = pzj1;
    }

    public Short getPzj2() {
        return pzj2;
    }

    public void setPzj2(Short pzj2) {
        this.pzj2 = pzj2;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public Short getPsb1() {
        return psb1;
    }

    public void setPsb1(Short psb1) {
        this.psb1 = psb1;
    }

    public Short getPsb2() {
        return psb2;
    }

    public void setPsb2(Short psb2) {
        this.psb2 = psb2;
    }

    public Short getPlx1() {
        return plx1;
    }

    public void setPlx1(Short plx1) {
        this.plx1 = plx1;
    }

    public Short getPlx2() {
        return plx2;
    }

    public void setPlx2(Short plx2) {
        this.plx2 = plx2;
    }

    public Short getPjx1() {
        return pjx1;
    }

    public void setPjx1(Short pjx1) {
        this.pjx1 = pjx1;
    }

    public Short getPjx2() {
        return pjx2;
    }

    public void setPjx2(Short pjx2) {
        this.pjx2 = pjx2;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
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