package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    // match any method in dao package
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // match any getter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getterMatcher() {}

    // match any setter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setterMatcher() {}

    // match any method in dao package except starting with get and set
    @Pointcut("forDaoPackage() && !(getterMatcher() || setterMatcher())")
    public void forDaoPackageWithoutGetterAndSetter() {}
}
