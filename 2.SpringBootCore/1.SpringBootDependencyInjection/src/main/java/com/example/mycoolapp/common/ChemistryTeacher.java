package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class ChemistryTeacher implements Teacher {
    @Override
    public String getSubject() {
        return "Teach students basic chemistry";
    }
}
