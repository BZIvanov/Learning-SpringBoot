package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {
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
