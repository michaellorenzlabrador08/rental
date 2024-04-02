package com.michael.mymicroservice.event;

public class ProductCreatedEvent {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
