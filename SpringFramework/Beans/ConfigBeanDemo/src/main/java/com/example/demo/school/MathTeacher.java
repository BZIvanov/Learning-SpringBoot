package com.example.demo.school;

// we are not going to use Component annotation here, because we are going to provide it as Bean
public class MathTeacher implements Teacher {
    public MathTeacher() {
        System.out.println("Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getSubject() {
        return "Math subject";
    }
}
