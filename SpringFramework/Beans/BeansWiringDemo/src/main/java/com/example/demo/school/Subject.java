package com.example.demo.school;

public class Subject {
    private final String name;

    public Subject(String name) {
        this.name = name;
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
