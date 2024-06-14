package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class MusicTeacher implements Teacher {
    @Override
    public String getSubject() {
        return "Teach students music";
    }
}
