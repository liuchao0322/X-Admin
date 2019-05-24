package com.emp.empsystem.entity;

public class SysRole {
    private int id;
    private String role;
    private String description;
public SysRole(){

}
    public SysRole(int id, String role, String description) {
        this.id = id;
        this.role = role;
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
