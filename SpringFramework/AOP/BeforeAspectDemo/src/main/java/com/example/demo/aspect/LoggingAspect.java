package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // in the console you will see the below println for matching methods
    // comment/uncomment the @Before annotations one at a time to experiment with different matching patterns


    @Before("execution(public void get*())")
    // @Before("execution(public void getSchoolName())")
    // @Before("execution(public void com.example.demo.school.StudentService.getStudentInfo())")
    // @Before("execution(double add*(..))")
    // @Before("execution(* add*(com.example.demo.school.Subject))")
    // @Before("execution(* add*(com.example.demo.school.Subject, ..))")
    public void logBeforeMethodExecution() {
        System.out.println("MATCHING METHOD ON THE LINE BELOW:");
    }
}
