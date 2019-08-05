package com.example.wing.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wing.modules.sys.entity.User;
import com.example.wing.modules.sys.service.UserService;
import com.example.wing.modules.sys.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Override
    @Transactional
    public void saveUser(User user) {
        this.save(user);
    }
}