package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements Teacher {
    public MathTeacher() {
        System.out.println("Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getSubject() {
        return "Teach students basic math";
    }
}
