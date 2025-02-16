package com.example.demo.school;

import org.springframework.stereotype.Component;

@Component
public class HistoryTeacher implements Teacher {
    // just for debugging/preview purpose
    public HistoryTeacher() {
        System.out.println("Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getSubject() {
        return "History subject";
    }
}
