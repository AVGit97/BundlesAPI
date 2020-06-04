package com.example.bundlesapi.helpers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringLengthValidator implements ConstraintValidator<StringLengthConstraint, String> {
    @Override
    public void initialize(StringLengthConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() >= 1 && s.length() <= 100;
    }
}
