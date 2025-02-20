package com.example.demo.aspect;

import com.example.demo.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("@annotation(logExecutionTime)") // Pointcut for methods with @LogExecutionTime
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Before matching method");

        Object result = joinPoint.proceed(); // Execute the method

        long endTime = System.currentTimeMillis();
        System.out.println("After matching method");
        System.out.println(joinPoint.getSignature() + " executed in " + (endTime - startTime) + " ms");

        return result; // Return the original method's result
    }
}
