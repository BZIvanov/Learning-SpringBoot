package com.example.demo.school;

import org.springframework.stereotype.Component;

// we named it historyTeacher just for the demo, this would be the default name if we didn't provide any
@Component("historyTeacher")
public class HistoryTeacher implements Teacher {
    @Override
    public String getSubject() {
        return "History subject";
    }
}
