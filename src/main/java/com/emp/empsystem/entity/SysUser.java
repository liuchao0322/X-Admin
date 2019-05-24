package com.emp.empsystem.entity;


import java.util.Date;

public class SysUser {
    private int id;
    private String username;
    private String password;
    private String phonenumber;
    private String email;
    private String address;
    private Date time;
    private String user_state;
    private SysRole sysRole;
    private SysPermission sysPermission;

    public SysUser() {

    }
    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public SysUser(String username, String password, String phonenumber, String email, String address) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }
    public SysUser(int id, String username, String password, String phonenumber, String email, String address, Date time, String user_state, SysRole sysRole, SysPermission sysPermission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.time = time;
        this.user_state = user_state;
        this.sysRole = sysRole;
        this.sysPermission = sysPermission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public SysPermission getSysPermission() {
        return sysPermission;
    }

    public void setSysPermission(SysPermission sysPermission) {
        this.sysPermission = sysPermission;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", user_state='" + user_state + '\'' +
                ", sysRole=" + sysRole +
                ", sysPermission=" + sysPermission +
                '}';
    }
}
