package com.baris.demo;

import com.baris.demo.kafka.KafkaProducer;
import com.baris.demo.kafka.WordCountProcessor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    private final WordCountProcessor wordCountProcessor;

    private final KafkaProducer kafkaProducer;

    @PostMapping("/message")
    public void addMessage(@RequestBody String message) {
        kafkaProducer.send("input-topic", message);
    }

    @GetMapping("/count/{word}")
    public Long getWordCount(@PathVariable("word") String word) {
        return wordCountProcessor.getWordCount(word);
    }
}
