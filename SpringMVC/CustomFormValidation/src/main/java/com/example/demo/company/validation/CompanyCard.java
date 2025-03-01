package com.example.demo.company.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// custom validation annotation
@Constraint(validatedBy = CompanyCardConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompanyCard {
    // the below fields are what we provide to our custom annotation
    String value() default "AWESOME";

    String message() default "Invalid Company Card, must start with AWESOME";

    // groups is used to group related constraints
    // in this demo groups is empty, which means this constraint is not part of any group
    Class<?>[] groups() default {};

    // payload is used to provide metadata information about validation
    // in this demo payload is empty, which means no additional data is provided
    Class<? extends Payload>[] payload() default {};
}
