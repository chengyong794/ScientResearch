package com.chengyong.util;

import java.io.Serializable;

public class personYear implements Serializable {
    private String statyear;
    private String endyear;

    public String getStatyear() {
        return statyear;
    }

    public void setStatyear(String statyear) {
        this.statyear = statyear;
    }

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }
}
