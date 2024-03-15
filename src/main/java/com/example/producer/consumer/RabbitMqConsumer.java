package com.example.producer.consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("header_queue"),
            exchange = @Exchange(value = "headerExchange", type = ExchangeTypes.HEADERS),
            key = "header1=hello"
    ))
    public void consumeHeaderQueueMessage(String message) {
        System.out.println("Received Message: " + message);
    }

}
