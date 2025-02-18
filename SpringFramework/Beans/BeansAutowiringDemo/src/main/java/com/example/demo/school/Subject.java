package com.example.demo.school;

import org.springframework.stereotype.Component;

@Component
public class Subject {
    private final String name = "Math"; // Hardcoded for simplicity

    public Subject() {
        System.out.println("Subject bean created by Spring");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
