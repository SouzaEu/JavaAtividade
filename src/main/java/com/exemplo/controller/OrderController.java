package com.exemplo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exemplo.model.OrderCreatedMessage;
import com.exemplo.service.OrderPublisher;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderPublisher orderPublisher;

    public OrderController(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreatedMessage message) {
        orderPublisher.publishOrderCreated(message);
        return ResponseEntity.ok("Order message published: " + message.getOrderId());
    }
}
