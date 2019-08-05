package com.example.wing.message;

import com.example.wing.modules.sys.entity.User;
import com.example.wing.modules.sys.service.UserMapper;
import com.example.wing.modules.sys.service.UserService;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaConsumer {
    @Autowired
    private UserService userService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate accountRedisTemplate;

//    @Autowired
//    private UserMapper userMapper;

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println(message);
            User user = new Gson().fromJson(message.toString(), User.class);
            System.out.println(user);
            userService.saveUser(user);
            accountRedisTemplate.opsForValue().set("sys:user", user);
            mongoTemplate.save(user);
//            userMapper.insert(user);
        }
    }

    @KafkaListener(topics = {"test-mysql"})
    public void listenT(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMsg = Optional.ofNullable(record.value());
        if (kafkaMsg.isPresent()) {
            Object message = kafkaMsg.get();
            System.out.println(message);
        }
    }

}
