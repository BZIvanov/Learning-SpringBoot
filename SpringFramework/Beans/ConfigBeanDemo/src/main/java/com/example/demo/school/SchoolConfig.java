package com.example.demo.school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {
    @Bean
    public Teacher mathTeacher() {
        return new MathTeacher();
    }
}
