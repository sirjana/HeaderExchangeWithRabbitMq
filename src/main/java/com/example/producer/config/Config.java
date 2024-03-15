package com.example.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public static final String EXCHANGE_NAME = "headerExchange";
    public static final String QUEUE_NAME = "header_queue";

    @Bean
    public Queue headerQueue() {
        return new Queue(QUEUE_NAME);
    }
    @Bean
    public HeadersExchange headerExchange() {
        return new HeadersExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue headerQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(headerQueue).to(headerExchange).where("header1").exists();
    }
}
