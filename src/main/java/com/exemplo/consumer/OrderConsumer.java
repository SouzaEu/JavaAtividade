package com.exemplo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.exemplo.model.OrderCreatedMessage;
import com.exemplo.rabbitmq.config.RabbitConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class OrderConsumer {
    private final Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME, containerFactory = "rabbitListenerContainerFactory")
    public void processOrderCreated(OrderCreatedMessage message) {
        log.info("Received OrderCreatedMessage: {}", message);
        // simular lógica de estoque / notificação
    }
}
