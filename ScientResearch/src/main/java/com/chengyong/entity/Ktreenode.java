package com.chengyong.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ktreenode implements Serializable {
    private Short treenodeid;

    private String title;

    private String href;

    private String icon;

    private String target;

    private Short parentid;

    private Short type;

    private List<Ktreenode> child = new ArrayList<Ktreenode>();

    public List<Ktreenode> getChild() {
        return child;
    }

    public void setChild(List<Ktreenode> child) {
        this.child = child;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getTreenodeid() {
        return treenodeid;
    }

    public void setTreenodeid(Short treenodeid) {
        this.treenodeid = treenodeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Short getParentid() {
        return parentid;
    }

    public void setParentid(Short parentid) {
        this.parentid = parentid;
    }
}