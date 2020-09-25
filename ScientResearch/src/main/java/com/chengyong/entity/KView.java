package com.chengyong.entity;

import java.util.ArrayList;
import java.util.List;

public class KView {
    private Short viewid;

    private String title;

    private String href;

    private String image;

    private String icon;

    private String target;

    private List<Ktreenode> child = new ArrayList<>();

    public Short getViewid() {
        return viewid;
    }

    public void setViewid(Short viewid) {
        this.viewid = viewid;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public List<Ktreenode> getChild() {
        return child;
    }

    public void setChild(List<Ktreenode> child) {
        this.child = child;
    }
}
