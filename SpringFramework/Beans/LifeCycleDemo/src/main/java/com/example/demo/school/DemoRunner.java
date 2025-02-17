package com.example.demo.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    private final ApplicationContext context;

    public DemoRunner(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = context.getBean(Student.class);

        System.out.println(student); // Student{name='John'}
    }
}
