package com.example.wing;

import com.example.wing.modules.sys.entity.User;
import com.example.wing.modules.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMysql {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoad() {
//        User user = new User(1L, "jesse", "king");
//        userService.saveUser(user);
    }
}
