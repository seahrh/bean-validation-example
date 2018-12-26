package com.sgcharts.beanvalidationexample.chapter06.constraintcomposition;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CarTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void valid_license_plate() {
		Car car = new Car( "1234567890ABCD");
		Set<ConstraintViolation<Car>> cvs = validator.validate( car );
		assertEquals( 0, cvs.size() );
	}

	@Test
	public void given_license_plate_when_lowercase_then_invalid() {
		Car car = new Car( "1234567890abcd");
		Set<ConstraintViolation<Car>> cvs = validator.validate( car );
		assertEquals( 1, cvs.size() );
		assertEquals(
				"Case mode must be UPPER.",
				cvs.iterator().next().getMessage()
		);
	}

	@Test
	public void given_license_plate_when_is_null_then_invalid() {
		Car car = new Car( null);
		Set<ConstraintViolation<Car>> cvs = validator.validate( car );
		assertEquals( 1, cvs.size() );
		assertEquals(
				"must not be null",
				cvs.iterator().next().getMessage()
		);
	}

	@Test
	public void given_license_plate_when_too_short_then_invalid() {
		Car car = new Car( "A");
		Set<ConstraintViolation<Car>> cvs = validator.validate( car );
		assertEquals( 1, cvs.size() );
		assertEquals(
				"size must be between 2 and 14",
				cvs.iterator().next().getMessage()
		);
	}

	@Test
	public void given_license_plate_when_too_long_then_invalid() {
		Car car = new Car( "1234567890ABCDE");
		Set<ConstraintViolation<Car>> cvs = validator.validate( car );
		assertEquals( 1, cvs.size() );
		assertEquals(
				"size must be between 2 and 14",
				cvs.iterator().next().getMessage()
		);
	}
}
