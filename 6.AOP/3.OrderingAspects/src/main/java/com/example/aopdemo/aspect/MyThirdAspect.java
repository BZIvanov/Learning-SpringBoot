package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyThirdAspect {
    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGetterAndSetter()")
    public void testAdviceThree() {
        System.out.println("TEST ADVICE 3:");
    }
}
