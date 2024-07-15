package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // in the console you will see the below println for matching methods
    // comment/uncomment the @Before annotations one at a time to experiment with different matching patterns

    @Before("execution(public void addUser())")
    // @Before("execution(public void com.example.aopdemo.dao.DatabaseLogger.addUser())")
    // @Before("execution(public void add*())")
    // @Before("execution(int add*(..))")
    // @Before("execution(* add*(com.example.aopdemo.CustomValue))")
    // @Before("execution(* add*(com.example.aopdemo.CustomValue, ..))")
    public void beforeTestingSomeMethodsAdvice() {
        System.out.println("MATCHING METHOD:");
    }
}
