package com.chengyong.entity;

import java.io.Serializable;

public class KSetask implements Serializable {
    private Short tid;

    private String taskjob;

    private String task;

    public Short getTid() {
        return tid;
    }

    public void setTid(Short tid) {
        this.tid = tid;
    }

    public String getTaskjob() {
        return taskjob;
    }

    public void setTaskjob(String taskjob) {
        this.taskjob = taskjob;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}