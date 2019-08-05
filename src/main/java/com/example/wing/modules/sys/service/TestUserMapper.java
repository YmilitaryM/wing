package com.example.wing.modules.sys.service;

import com.example.wing.modules.sys.entity.TestUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestUserMapper {

    @Insert("insert into public.\"user\" values(#{id}, #{user_name}, #{user_password})")
    Integer insert(TestUser user);
}
