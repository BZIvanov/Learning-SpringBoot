package com.example.demo.school;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        this.name = "John";
    }

    // in this demo this life cycle will be called after we shut down the server
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Student bean");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
