package com.devalok.microservice.order_service.controller;

import com.devalok.microservice.basedomains.dto.Order;
import com.devalok.microservice.basedomains.dto.OrderEvent;
import com.devalok.microservice.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Order status is in pending state.");
        event.setOrder(order);
        orderProducer.sendMessage(event);

        return "Order placed successfully.";
    }
}
