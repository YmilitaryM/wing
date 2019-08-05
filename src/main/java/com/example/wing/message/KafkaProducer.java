package com.example.wing.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    public void send(String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }
}
