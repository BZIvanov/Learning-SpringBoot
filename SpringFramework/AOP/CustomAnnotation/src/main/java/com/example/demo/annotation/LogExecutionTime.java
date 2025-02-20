package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Retain at runtime so AOP can process it
@Target({ElementType.METHOD}) // Can be applied to methods only
public @interface LogExecutionTime {
}
