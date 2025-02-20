package com.example.demo;

import com.example.demo.school.SchoolService;
import com.example.demo.school.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoRunner implements CommandLineRunner {
    private final ApplicationContext context;

    @Autowired
    public DemoRunner(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        SchoolService schoolService = context.getBean(SchoolService.class);
        List<Teacher> teachers = schoolService.getTeachers();

        System.out.println("FINAL VALUES: " + teachers);
    }
}
