package com.example.wing.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;
    @TableId
    private Long id;
    private String userName;
    private String passWord;

    public User(){

    }
    public User(Long id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Long getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.passWord;
    }
}
