package com.exemplo.model;

import java.util.List;

public class OrderCreatedMessage {
    private String orderId;
    private String clientId;
    private List<OrderItem> items;

    public OrderCreatedMessage() {}

    public OrderCreatedMessage(String orderId, String clientId, List<OrderItem> items) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderCreatedMessage{" +
                "orderId='" + orderId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", items=" + items +
                '}';
    }
}
