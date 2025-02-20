package com.example.demo.aspect;

import com.example.demo.school.Teacher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class SchoolAspect {
    @AfterReturning(
            pointcut = "execution(* com.example.demo.school.SchoolService.getTeachers(..))",
            returning = "result"
    )
    public void afterReturningGetTeachersAdvice(JoinPoint joinPoint, List<Teacher> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AFTER RETURNING MATCHING METHOD: " + method);
        System.out.println("AFTER RETURNING NOT MODIFIED RESULT: " + result);

        convertValuesToLowerCase(result);

        System.out.println("AFTER RETURNING MODIFIED RESULT: " + result);
    }

    private void convertValuesToLowerCase(List<Teacher> result) {
        for (Teacher teacher : result) {
            String lowerCaseValue = teacher.getName().toLowerCase();
            teacher.setName(lowerCaseValue);
        }
    }
}
