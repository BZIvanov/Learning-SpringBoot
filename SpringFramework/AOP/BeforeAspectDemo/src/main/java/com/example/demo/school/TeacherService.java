package com.example.demo.school;

import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    public void getTeacherInfo() {
        System.out.println("\tExecuting getTeacherInfo method...\n");
    }

    public void getSchoolName() {
        System.out.println("\tExecuting teacher getSchoolName method...\n");
    }

    public void addSubject(Subject subject) {
        System.out.println("\tExecuting addSubject method...\n");
    }

    public void addSubject(Subject subject, int grade) {
        System.out.println("\tExecuting addSubject for grade method...\n");
    }
}
