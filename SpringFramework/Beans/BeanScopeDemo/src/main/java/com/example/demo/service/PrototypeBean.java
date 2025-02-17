package com.example.demo.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE) // A new instance is created each time
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("PrototypeBean instance created!");
    }
}
