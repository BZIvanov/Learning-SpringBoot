package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class HistoryTeacher implements Teacher {
    @Override
    public String getSubject() {
        return "Teach students history";
    }
}
