package com.michael.propertyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @GetMapping("/")
    public String hello(){
        return "Hello Property";
    }

}
