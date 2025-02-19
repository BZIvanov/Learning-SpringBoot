package com.example.demo.school;

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
        System.out.println("Before retrieving Teacher from Spring context");

        context.getBean(Teacher.class);

        System.out.println("After retrieving Teacher from Spring context");

        /*
            The logs we will see will be:
                Before retrieving Teacher from Spring context
                Teacher bean created by Spring
                After retrieving Teacher from Spring context
            The teacher bean will be initialized only after it is used.
            Without the @Lazy annotation it will be initialized before the print lines.
         */
    }
}
