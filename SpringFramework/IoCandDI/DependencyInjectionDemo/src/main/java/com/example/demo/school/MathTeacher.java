package com.example.demo.school;

import org.springframework.stereotype.Component;

// Component decorator will make this class Bean, which is available for dependency injection
@Component("mathTeacher")
public class MathTeacher implements Teacher {
    @Override
    public String getSubject() {
        return "Math subject";
    }
}
