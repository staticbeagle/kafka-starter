package com.wildbitsfoundry.kafkasensorsdemo.controller;

import com.wildbitsfoundry.kafkasensorsdemo.producer.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final Producer producer;

    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        producer.sendMessage("my-topic", message);
        return "Message sent: " + message;
    }

}
