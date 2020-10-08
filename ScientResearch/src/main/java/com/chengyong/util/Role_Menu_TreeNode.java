package com.chengyong.util;

import java.util.ArrayList;
import java.util.List;

public class Role_Menu_TreeNode {
    private String title;
    private Integer id;
    private boolean checked;
    private Object children;

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public Role_Menu_TreeNode() {
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
