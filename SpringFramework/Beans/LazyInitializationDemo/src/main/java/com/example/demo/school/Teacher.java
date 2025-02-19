package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value = "teacherBean")
@Lazy
public class Teacher {
    @Autowired
    public Teacher() {
        System.out.println("Teacher bean created by Spring");
    }
}
