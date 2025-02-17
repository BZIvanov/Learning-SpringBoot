package com.example.demo.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    private final ApplicationContext applicationContext;

    public DemoRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        if (applicationContext instanceof GenericApplicationContext context) {
            // Registering a new bean dynamically
            context.registerBean("historyTeacher", Teacher.class, () -> new Teacher("History"));

            // Fetch the dynamically registered bean
            Teacher teacher = context.getBean("historyTeacher", Teacher.class);
            System.out.println(teacher.getSubject()); // "History"
        }
    }
}
