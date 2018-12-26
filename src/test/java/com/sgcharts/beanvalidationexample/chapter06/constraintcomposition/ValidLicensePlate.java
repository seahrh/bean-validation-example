//tag::include[]
package com.sgcharts.beanvalidationexample.chapter06.constraintcomposition;


import com.sgcharts.beanvalidationexample.chapter06.CaseMode;
import com.sgcharts.beanvalidationexample.chapter06.CheckCase;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//tag::include[]
@NotNull
@Size(min = 2, max = 14)
@CheckCase(CaseMode.UPPER)
@Target({METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidLicensePlate {

    String message() default
            "{com.sgcharts.beanvalidationexample.chapter06.constraintcomposition.ValidLicensePlate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
//end::include[]
