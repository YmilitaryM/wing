package com.example.wing.common.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisUtils {

    public void set(RedisTemplate redisTemplate, Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(RedisTemplate redisTemplate, Object key) {
        return redisTemplate.opsForValue().get(key);
    }


}
