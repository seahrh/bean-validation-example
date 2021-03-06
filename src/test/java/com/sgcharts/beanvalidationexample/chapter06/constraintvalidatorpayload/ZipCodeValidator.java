//tag::include[]
package com.sgcharts.beanvalidationexample.chapter06.constraintvalidatorpayload;

//end::include[]

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

//tag::include[]
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	public String countryCode;

	@Override
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		if ( object == null ) {
			return false;
		}
		String countryCode = constraintContext
				.unwrap( HibernateConstraintValidatorContext.class )
				.getConstraintValidatorPayload( String.class );
		if ( "US".equals( countryCode ) ) {
			return object.length() == 6;
		}
		if ( "FR".equals( countryCode ) ) {
			return object.length() == 5;
		}
		return false;
	}
}
//end::include[]
