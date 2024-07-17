package com.example.aopdemo.aspect;

import com.example.aopdemo.CustomValue;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.DatabaseLogger.findValues(..))",
            returning = "result"
    )
    public void afterReturningFindValuesAdvice(JoinPoint joinPoint, List<CustomValue> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AFTERRETURNING MATCHING METHOD: " + method);
        System.out.println("AFTERRETURNING NOT MODIFIED RESULT: " + result);

        convertValuesToLowerCase(result);

        System.out.println("AFTERRETURNING MODIFIED RESULT: " + result);
    }

    private void convertValuesToLowerCase(List<CustomValue> result) {
        for (CustomValue customValue : result) {
            String lowerCaseValue = customValue.getType().toLowerCase();
            customValue.setType(lowerCaseValue);
        }
    }
}
