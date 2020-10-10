package com.chengyong.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class KKyrole implements Serializable {
    private Short rId;

    private String rName;

    private String rDesc;

    private String rCode;

    private Short rType;

    //解决 springmvc 后台大写字段名称 返回前台变成小写
    @JsonProperty
    private Boolean  LAY_CHECKED;

    public Boolean getLAY_CHECKED() {
        return LAY_CHECKED;
    }

    public void setLAY_CHECKED(Boolean LAY_CHECKED) {
        this.LAY_CHECKED = LAY_CHECKED;
    }

    public Short getrType() {
        return rType;
    }

    public void setrType(Short rType) {
        this.rType = rType;
    }

    public Short getrId() {
        return rId;
    }

    public void setrId(Short rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }
}