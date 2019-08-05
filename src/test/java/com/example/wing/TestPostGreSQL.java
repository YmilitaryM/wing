package com.example.wing;

import com.example.wing.modules.sys.entity.TestUser;
import com.example.wing.modules.sys.entity.User;
import com.example.wing.modules.sys.service.TestUserMapper;
import com.example.wing.modules.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPostGreSQL {
//    @Autowired
//    UserService userService;

    @Autowired
    TestUserMapper testUserMapper;

    @Test
    public void ContextLoads() {
//        User user = new User(102l, "lll", "ooo");
//        userService.saveUser(user);

        TestUser testUser = new TestUser(103, "jx", "ko");
        testUserMapper.insert(testUser);
    }
}
