package com.example.demo;

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
        // as second parameter we provide String.class, because otherwise the returned type is just object
        // because there is no way for Spring to know what type our bean will be
        String firstName = context.getBean("firstName", String.class);
        String fullName = context.getBean("fullName", String.class);

        System.out.println("First Name: " + firstName);
        System.out.println("Full Name: " + fullName);

        // here is how, we can also get the count of the beans we have
        System.out.println("Total beans count: " + context.getBeanDefinitionCount());
    }
}
