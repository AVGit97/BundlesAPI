package com.example.bundlesapi.helpers;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringLengthValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringLengthConstraint {
    String message() default "String should be between 1 and 100 characters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
