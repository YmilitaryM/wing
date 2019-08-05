package com.example.wing.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wing.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {

    // 查询用户密码
    String queryUserPwd(Long userId);

    //查询用户名

    String queryUserName(Long userId);
}
