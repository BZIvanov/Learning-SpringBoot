package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // match any method in school package
    @Pointcut("execution(* com.example.demo.school.*.*(..))")
    private void forSchoolPackage() {}

    // match any method prefixed with get
    @Pointcut("execution(* com.example.demo.school.*.get*(..))")
    private void forGetMatcher() {}

    // match any method prefixed with calc
    @Pointcut("execution(* com.example.demo.school.*.calc*(..))")
    private void forCalcMatcher() {}

    @Before("forSchoolPackage() && !forGetMatcher() && !forCalcMatcher()")
    public void beforeTestingSomeMethodsAdvice() {
        System.out.println("MATCHING METHOD ON THE LINE BELOW:");
    }
}
