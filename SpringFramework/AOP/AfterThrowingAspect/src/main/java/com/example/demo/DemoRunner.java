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
        List<Teacher> teachers = null;

        try {
            // change the parameter to true/false to test both scenarios
            // with false only @After annotation will run
            // with true both @AfterThrowing and @After will run, because of the error and finally
            teachers = schoolService.getTeachers(true);
        }
        catch (Exception exc) {
            System.out.println("APP EXCEPTION: " + exc);
        }

        System.out.println("APP VALUES: " + teachers);
    }
}
