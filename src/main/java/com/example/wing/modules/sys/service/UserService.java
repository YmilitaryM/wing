package com.example.wing.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.wing.modules.sys.entity.User;

public interface UserService extends IService<User> {
    // 保存用户信息到mysql
    void saveUser(User user);
}
