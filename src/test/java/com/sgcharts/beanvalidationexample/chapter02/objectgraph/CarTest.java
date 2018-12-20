package com.sgcharts.beanvalidationexample.chapter02.objectgraph;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Test nested containers - List nested in Map.
 */
public class CarTest {

	private static Validator validator;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void when_driver_is_valid_then_valid() {
		Person driver = new Person("john");
		Car car = new Car(driver);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}

	@Test
	public void when_driver_is_null_then_invalid() {
		Car car = new Car(null);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		ConstraintViolation cv = constraintViolations.iterator().next();
		assertEquals( "driver must not be null",
				cv.getPropertyPath() + " " + cv.getMessage() );
	}

	@Test
	public void when_driver_is_invalid_then_invalid() {
		Person driver = new Person(null);
		Car car = new Car(driver);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		ConstraintViolation cv = constraintViolations.iterator().next();
		assertEquals( "driver.name must not be null",
				cv.getPropertyPath() + " " + cv.getMessage() );
	}

}
