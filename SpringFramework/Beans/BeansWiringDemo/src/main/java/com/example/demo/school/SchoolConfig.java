package com.example.demo.school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {
    @Bean
    public Subject mathSubject() {
        return new Subject("Math");
    }

    // Teacher is dependent on Subject and Spring will inject it
    @Bean
    public Teacher mathTeacher(Subject subject) {
        return new Teacher("John Doe", subject);
    }
}
