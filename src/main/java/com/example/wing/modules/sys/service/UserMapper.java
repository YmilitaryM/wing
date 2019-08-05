package com.example.wing.modules.sys.service;

import com.example.wing.modules.sys.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(id,user_name,user_password) values(#{id},#{userName},#{passWord})")
    public int insert(User user);
}
