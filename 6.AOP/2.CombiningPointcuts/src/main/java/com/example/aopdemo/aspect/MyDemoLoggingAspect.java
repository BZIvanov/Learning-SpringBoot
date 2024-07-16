package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // match any method in dao package
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    // match any getter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    private void getterMatcher() {}

    // match any setter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    private void setterMatcher() {}

    // match any method in dao package except starting with get and set
    @Pointcut("forDaoPackage() && !(getterMatcher() || setterMatcher())")
    private void forDaoPackageWithoutGetterAndSetter() {}

    @Before("forDaoPackageWithoutGetterAndSetter()")
    public void beforeTestingSomeMethodsAdvice() {
        System.out.println("MATCHING METHOD:");
    }
}
