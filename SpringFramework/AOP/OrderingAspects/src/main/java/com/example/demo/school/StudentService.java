package com.example.demo.school;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void getStudentInfo() {
        System.out.println("\tExecuting getStudentInfo method...\n");
    }

    public void getSchoolName() {
        System.out.println("\tExecuting getSchoolName method...\n");
    }

    public void addGrade(double grade) {
        System.out.println("\tExecuting addGrade method...\n");
    }

    public void calcGradesAverage() {
        System.out.println("\tExecuting calcGradesAverage method...\n");
    }
}
