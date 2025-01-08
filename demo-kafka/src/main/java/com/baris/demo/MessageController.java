package com.baris.demo;

import com.baris.demo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Value("${test.topic}")
    private String topic;

    @PostMapping("/message")
    public void addMessage(@RequestBody String message) {
        kafkaProducer.send(topic, message);
    }
}
