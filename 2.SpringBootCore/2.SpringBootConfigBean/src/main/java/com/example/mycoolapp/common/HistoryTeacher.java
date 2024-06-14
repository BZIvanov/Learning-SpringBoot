package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class HistoryTeacher implements Teacher {
    public HistoryTeacher() {
        System.out.println("Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getSubject() {
        return "Teach students history";
    }
}
