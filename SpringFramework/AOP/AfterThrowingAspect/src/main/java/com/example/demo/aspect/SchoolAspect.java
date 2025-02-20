package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SchoolAspect {
    @After("execution(* com.example.demo.school.SchoolService.getTeachers(..))")
    public void afterFinallyGetTeachersAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AFTER FINALLY MATCHING METHOD: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.demo.school.SchoolService.getTeachers(..))",
            throwing = "exc"
    )
    public void afterThrowingGetTeachersAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AFTER THROWING MATCHING METHOD: " + method);
        System.out.println("AFTER THROWING EXCEPTION: " + exc);
    }
}
