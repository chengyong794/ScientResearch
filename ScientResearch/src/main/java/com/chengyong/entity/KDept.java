package com.chengyong.entity;

import java.io.Serializable;

public class KDept implements Serializable {
    private Short did;

    private String dname;

    private String dperson;

    private Short profesornum;

    private Short fprofesornum;

    private Short lecturernum;

    private Short tanum;

    private Short keshi;

    private Short jigou;

    public Short getDid() {
        return did;
    }

    public void setDid(Short did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDperson() {
        return dperson;
    }

    public void setDperson(String dperson) {
        this.dperson = dperson;
    }

    public Short getProfesornum() {
        return profesornum;
    }

    public void setProfesornum(Short profesornum) {
        this.profesornum = profesornum;
    }

    public Short getFprofesornum() {
        return fprofesornum;
    }

    public void setFprofesornum(Short fprofesornum) {
        this.fprofesornum = fprofesornum;
    }

    public Short getLecturernum() {
        return lecturernum;
    }

    public void setLecturernum(Short lecturernum) {
        this.lecturernum = lecturernum;
    }

    public Short getTanum() {
        return tanum;
    }

    public void setTanum(Short tanum) {
        this.tanum = tanum;
    }

    public Short getKeshi() {
        return keshi;
    }

    public void setKeshi(Short keshi) {
        this.keshi = keshi;
    }

    public Short getJigou() {
        return jigou;
    }

    public void setJigou(Short jigou) {
        this.jigou = jigou;
    }
}