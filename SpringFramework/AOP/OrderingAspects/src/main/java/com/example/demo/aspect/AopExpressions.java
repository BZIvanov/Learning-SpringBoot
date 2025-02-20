package com.example.demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    // match any method in dao package
    @Pointcut("execution(* com.example.demo.school.*.*(..))")
    public void forSchoolPackage() {}

    // match any get prefixed method
    @Pointcut("execution(* com.example.demo.school.*.get*(..))")
    public void getGetPrefixedMethods() {}

    // match any calc prefixed method
    @Pointcut("execution(* com.example.demo.school.*.calc*(..))")
    public void getCalcPrefixedMethods() {}

    // match any method in school package except starting with get and calc
    @Pointcut("forSchoolPackage() && !(getGetPrefixedMethods() || getCalcPrefixedMethods())")
    public void forSchoolPackageWithoutGetAndCalcMethods() {}
}
