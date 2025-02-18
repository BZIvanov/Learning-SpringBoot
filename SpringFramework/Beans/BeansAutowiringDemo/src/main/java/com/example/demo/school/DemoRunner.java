package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    private final Teacher teacher;

    // Inject Teacher directly
    @Autowired
    public DemoRunner(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Teacher's Name: " + teacher.getFullName());
        System.out.println("Teacher's Subject: " + teacher.getSubject().getName());
    }
}
