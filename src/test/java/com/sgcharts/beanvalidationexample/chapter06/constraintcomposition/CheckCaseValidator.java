//tag::include[]
package com.sgcharts.beanvalidationexample.chapter06.constraintcomposition;

//end::include[]

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//tag::include[]
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (object == null) {
            return true;
        }
        if (caseMode == CaseMode.UPPER) {
            return object.equals(object.toUpperCase());
        }
        return object.equals(object.toLowerCase());
    }
}
//end::include[]
