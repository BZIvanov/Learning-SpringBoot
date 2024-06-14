package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

// Component decorator will make this class Bean, which is available for dependency injection
@Component
public class MathTeacher implements Teacher {
    @Override
    public String getSubject() {
        return "Teach students basic math";
    }
}
