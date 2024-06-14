package com.example.mycoolapp.common;

// we are not going to use Component annotation here, because we are going to provide it as Bean
public class DanceTeacher implements Teacher {
    // just for debugging/preview purpose
    public DanceTeacher() {
        System.out.println("Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getSubject() {
        return "Teach students dancing";
    }
}
