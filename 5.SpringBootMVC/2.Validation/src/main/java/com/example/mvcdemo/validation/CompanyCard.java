package com.example.mvcdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// custom validation

@Constraint(validatedBy = CompanyCardConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompanyCard {
    String value() default "AWESOME";

    String message() default "Invalid Company Card, must start with AWESOME";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
