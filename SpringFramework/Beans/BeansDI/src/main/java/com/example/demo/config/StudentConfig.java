package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public String firstName() {
        return "John";
    }

    @Bean
    public String lastName() {
        return "Doe";
    }

    @Bean
    public String fullName(String firstName, String lastName) { // Use dependency injection
        return firstName + " " + lastName;
    }
}
