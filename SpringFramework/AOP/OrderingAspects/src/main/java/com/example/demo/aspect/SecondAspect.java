package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class SecondAspect {
    @Before("com.example.demo.aspect.AopExpressions.forSchoolPackageWithoutGetAndCalcMethods()")
    public void testAdviceTwo() {
        System.out.println("TEST ADVICE 2:");
    }
}
