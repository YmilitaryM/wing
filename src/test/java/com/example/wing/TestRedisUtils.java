package com.example.wing;

import com.example.wing.common.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisUtils {

    @Autowired
    private RedisTemplate accountRedisTemplate;

    private RedisUtils redisUtils = new RedisUtils();

    @Test
    public void ContextLoad() {
        redisUtils.set(accountRedisTemplate, "test", "value");
    }

}


