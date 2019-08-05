package com.example.wing.modules.controller;


import com.example.wing.common.utils.R;
import com.example.wing.modules.sys.entity.User;
import com.example.wing.modules.sys.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class SaveUser {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save(@RequestBody User user) {
        System.out.println(user);
        userService.saveUser(user);
        return R.ok();
    }
}
