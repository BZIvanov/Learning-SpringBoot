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
        Teacher teacher = context.getBean(Teacher.class);
        Subject subject = context.getBean(Subject.class);

        System.out.println("Teacher Spring Context: " + teacher.getFullName());
        System.out.println("Subject Spring Context: " + subject.getName());
        System.out.println("Teacher's subject: " + teacher.getSubject());
    }
}
