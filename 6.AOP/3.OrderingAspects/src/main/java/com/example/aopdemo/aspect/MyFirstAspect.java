package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyFirstAspect {
    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGetterAndSetter()")
    public void testAdviceOne() {
        System.out.println("TEST ADVICE 1:");
    }
}
