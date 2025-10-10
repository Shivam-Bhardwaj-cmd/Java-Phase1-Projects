package com.example.helloapi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getHelloMessage() {
        return "Hello from Spring Boot!";
    }
}
