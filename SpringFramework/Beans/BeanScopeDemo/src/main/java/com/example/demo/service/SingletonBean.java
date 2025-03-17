package com.example.demo.service;

import org.springframework.stereotype.Component;

// if we don't specify the scope of the bean, it will be a singleton bean by default
// Singleton beans are created only once and the same instance is returned every time
@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean instance created!");
    }
}
