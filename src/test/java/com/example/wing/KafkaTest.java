package com.example.wing;

import com.example.wing.modules.sys.entity.User;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void contextLoads() throws Exception{
        User user = new User(19L, "lll", "ooo");
        String userJsonString = new Gson().toJson(user);
        kafkaTemplate.send("test", userJsonString);
        //kafkaTemplate.send("test-mysql", userJsonString);

    }
}
