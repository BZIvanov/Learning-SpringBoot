package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @After("execution(* com.example.aopdemo.dao.DatabaseLogger.findValues(..))")
    public void afterFinallyFindValuesAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AFTER FINALLY MATCHING METHOD: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.aopdemo.dao.DatabaseLogger.findValues(..))",
            throwing = "exc"
    )
    public void afterThrowingFindValuesAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AFTERTHROWING MATCHING METHOD: " + method);
        System.out.println("AFTERTHROWING EXCEPTION: " + exc);
    }
}
