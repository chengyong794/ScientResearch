package com.chengyong.entity;

import java.io.Serializable;

public class KKyrole implements Serializable {
    private Short rId;

    private String rName;

    private String rDesc;

    private String rCode;

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