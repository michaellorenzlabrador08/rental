package com.michael.mymicroservice.controller;

import com.michael.mymicroservice.event.ProductCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final String PRODUCT_CREATED_TOPIC = "product-created";
    private static final String PRODUCT_SEND_TOPIC = "product-send";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProductController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping("/create")
    public ResponseEntity<String> createProduct() {
        try {
            // Convert ProductRequest to ProductCreatedEvent
            ProductCreatedEvent event = convertToProductCreatedEvent();
            // Publish product-created event to Kafka topic
            System.out.println("SEND EVENT");
            System.out.println(event);

            kafkaTemplate.send(PRODUCT_CREATED_TOPIC, "message");

            return ResponseEntity.ok("Product created successfully. Product Name: " + event.getName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing product creation request: " + e.getMessage());
        }
    }

    private ProductCreatedEvent convertToProductCreatedEvent() {
        // Convert OrderRequest to OrderCreatedEvent
        // Implement conversion logic as needed
        ProductCreatedEvent event  = new ProductCreatedEvent();
        event.setName("my new event");
        return event;
    }

    @GetMapping("/send")
    public void send() {
            System.out.println("SEND EVENT");
            kafkaTemplate.send(PRODUCT_SEND_TOPIC, "message");
    }

}
