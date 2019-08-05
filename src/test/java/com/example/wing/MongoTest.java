package com.example.wing;

import com.example.wing.modules.sys.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
        User user = new User(2L, "jesse", "king");
        mongoTemplate.save(user);
        List<User> users = mongoTemplate.findAll(User.class);
        System.out.println(users);
    }

}
