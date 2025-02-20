package com.example.demo.school;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String getStudentInfo() {
        System.out.println("Executing getStudentInfo method...");
        return "Student Name: John Doe";
    }
}
