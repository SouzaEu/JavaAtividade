package com.exemplo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.exemplo.rabbitmq.config.RabbitConfig;
import com.exemplo.model.OrderCreatedMessage;

@Service
public class OrderPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Logger log = LoggerFactory.getLogger(OrderPublisher.class);

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrderCreated(OrderCreatedMessage message) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, message);
        log.info("Published OrderCreatedMessage: {}", message);
    }
}
