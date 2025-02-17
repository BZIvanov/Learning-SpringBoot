package com.example.demo.school;

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

    public void greet() {
        System.out.println("Hello from student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
