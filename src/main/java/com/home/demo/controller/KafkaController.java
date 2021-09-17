package com.home.demo.controller;

import com.home.demo.kafka.ProducerKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final ProducerKafka producer;

    @PostMapping ("/publish")
    public void method(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
