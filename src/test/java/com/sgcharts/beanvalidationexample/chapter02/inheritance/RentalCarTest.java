package com.sgcharts.beanvalidationexample.chapter02.inheritance;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RentalCarTest {

	private static Validator validator;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.byProvider( HibernateValidator.class )
				.configure()
				.buildValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void when_manufacturer_and_rental_station_are_not_null_then_valid() {
		RentalCar car = new RentalCar("my manufacturer", "my rental station");
		Set<ConstraintViolation<RentalCar>> constraintViolations = validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}

	@Test
	public void when_manufacturer_is_null_then_invalid() {
		RentalCar car = new RentalCar(null, "my rental station");
		Set<ConstraintViolation<RentalCar>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals( "manufacturer must not be null",
				constraintViolations.iterator().next().getMessage() );
	}

	@Test
	public void when_rental_station_is_null_then_invalid() {
		RentalCar car = new RentalCar("my manufacturer", null);
		Set<ConstraintViolation<RentalCar>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals( "rentalStation must not be null",
				constraintViolations.iterator().next().getMessage() );
	}

}
