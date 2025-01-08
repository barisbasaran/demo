package com.baris.demo.service;

import org.springframework.stereotype.Service;

/**
 * Service class for greeting
 */
@Service
public class GreetingService {

    public String greet() {
        return "Greetings from Spring Boot!";
    }
}
