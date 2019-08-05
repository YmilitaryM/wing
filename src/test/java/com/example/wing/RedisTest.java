package com.example.wing;

import com.example.wing.modules.sys.entity.User;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate accountRedisTemplate;

    @Autowired
    private RedisTemplate friendRedisTemplate;

    @Test
    public void ContextLoad() {
        redisTemplate.opsForValue().set("test-redisTemplate", "test-redisTemplate:hello");
        friendRedisTemplate.opsForValue().set("friend-redisTemplate", "friendRedisTemplate");
        accountRedisTemplate.opsForValue().set("account-redisTemplate", "accountRedisTemplate");
    }
}
