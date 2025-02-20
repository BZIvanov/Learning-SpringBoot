package com.example.demo;

import com.example.demo.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    private final ApplicationContext context;

    @Autowired
    public DemoRunner(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        StudentService studentService = context.getBean(StudentService.class);
        studentService.getStudentInfo();
        studentService.getSchoolName();
        studentService.addGrade(4.5);
        studentService.calcGradesAverage();
    }
}
