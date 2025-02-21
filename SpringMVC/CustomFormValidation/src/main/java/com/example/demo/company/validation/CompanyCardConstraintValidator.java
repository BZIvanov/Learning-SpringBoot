package com.example.demo.company.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompanyCardConstraintValidator implements ConstraintValidator<CompanyCard, String> {
    private String companyPrefix;

    @Override
    public void initialize(CompanyCard companyCard) {
        companyPrefix = companyCard.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // this field is no required, so it is valid if not provided
        boolean isValid = true;

        if (s != null) {
            isValid = s.startsWith(companyPrefix);
        }

        return isValid;
    }
}
