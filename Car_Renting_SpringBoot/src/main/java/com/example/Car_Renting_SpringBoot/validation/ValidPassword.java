package com.example.Car_Renting_SpringBoot.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordValidatorCustom.class)
@Target({ElementType.PARAMETER, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidPassword {
    String message() default "{ValidPassword.User.password.validation}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
