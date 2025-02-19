package com.example.demo.school;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void getStudentInfo() {
        System.out.println("\tExecuting getStudentInfo method...\n");
    }

    public void getSchoolName() {
        System.out.println("\tExecuting student getSchoolName method...\n");
    }

    public double addGrade(double grade) {
        System.out.println("\tExecuting addGrade method...\n");
        return grade;
    }
}
