package com.emp.empsystem.entity;

import java.util.Date;

/**
 * @Author Liu
 * @create 2019/5/7 8:38
 */
public class SysLog {
    private String username;
    private Integer object;
    private String operation;
    private Date time;

    public SysLog(String username, Integer object, String operation, Date time) {
        this.username = username;
        this.object = object;
        this.operation = operation;
        this.time = time;
    }
    public SysLog(String username, Integer object, String operation, java.sql.Timestamp time) {
        this.username = username;
        this.object = object;
        this.operation = operation;
        this.time = time;
    }
    public SysLog(String username, Integer object, String operation) {
        this.username = username;
        this.object = object;
        this.operation = operation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getObject() {
        return object;
    }

    public void setObject(Integer object) {
        this.object = object;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
