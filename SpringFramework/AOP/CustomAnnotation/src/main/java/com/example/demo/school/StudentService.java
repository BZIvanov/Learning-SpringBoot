package com.example.demo.school;

import com.example.demo.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @LogExecutionTime
    public String getStudentInfo() {
        System.out.println("Executing getStudentInfo method...");
        return "Student Name: John Doe";
    }
}
