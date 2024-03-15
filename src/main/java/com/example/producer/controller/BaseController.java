package com.example.producer.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String EXCHANGE_NAME = "headerExchange";
    private static final String ROUTING_KEY = "otp";

    @PostMapping("/send")
    public String sendMessageToRabbitMQ(@RequestHeader("header1") String header1) {
        String message = "Your message content here";
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
        return "Message sent to RabbitMQ";
    }
}
