package com.example.wing.modules.sys.entity;

public class TestUser {
    private Integer id;
    private String user_name;
    private String user_password;

    public Integer getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public TestUser(Integer id, String user_name, String user_password) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
    }
}
