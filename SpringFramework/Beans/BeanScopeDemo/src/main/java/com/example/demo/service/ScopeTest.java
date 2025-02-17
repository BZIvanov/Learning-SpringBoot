package com.example.demo.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScopeTest implements CommandLineRunner {
    private final ApplicationContext context;

    public ScopeTest(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        PrototypeBean bean2 = context.getBean(PrototypeBean.class);

        // new instance will be created for each bean
        System.out.println("BEAN 1: " + bean1);
        System.out.println("BEAN 2: " + bean2);
    }
}
