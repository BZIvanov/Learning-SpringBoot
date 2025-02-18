package com.example.demo.school;

public class Teacher {
    private final String fullName;
    private final Subject subject;

    public Teacher(String fullName, Subject subject) {
        this.fullName = fullName;
        this.subject = subject;
        System.out.println("Teacher bean created by Spring");
    }

    public String getFullName() {
        return fullName;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", subject=" + subject +
                '}';
    }
}
