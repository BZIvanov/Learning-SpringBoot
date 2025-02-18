package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private final String fullName = "John Doe";
    private final Subject subject;

    // The @Autowired constructor tells Spring to inject the Subject bean automatically.
    @Autowired
    public Teacher(Subject subject) {
        this.subject = subject;
        System.out.println("Teacher bean created by Spring");
    }

    public String getFullName() {
        return fullName;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", subject=" + subject +
                '}';
    }
}
