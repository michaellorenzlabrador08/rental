package com.michael.productservice.event;

import com.michael.mymicroservice.event.ProductCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventListener {
    @KafkaListener(topics = "product-created", groupId = "product-service-group")
    public void listen(String event) {
        // Process the incoming ProductCreatedEvent
        System.out.println("Received ProductCreatedEvent: " + event);
        // Add logic to create the product in the database or perform other operations
    }

    @KafkaListener(topics = "product-send", groupId = "product-service-group")
    public void listen2(String event) {
        // Process the incoming ProductCreatedEvent
        System.out.println("Received SEND: " + event);
        // Add logic to create the product in the database or perform other operations
    }

}
