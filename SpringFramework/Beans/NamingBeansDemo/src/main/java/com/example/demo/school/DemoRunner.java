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
        // as first parameter, we will provide the name of the Bean, otherwise we will get en error
        // because we have 3 Student Beans and cannot select one of them by only providing class name
        Student student1 = context.getBean("student1", Student.class);
        Student student2 = context.getBean("student2", Student.class);
        Student student3 = context.getBean("ani", Student.class);

        System.out.println(student1); // Student{name='John'}
        System.out.println(student2); // Student{name='Jake'}
        System.out.println(student3); // Student{name='Anna'}
    }
}
