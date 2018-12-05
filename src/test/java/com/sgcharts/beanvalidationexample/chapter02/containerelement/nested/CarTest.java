package com.sgcharts.beanvalidationexample.chapter02.containerelement.nested;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
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
	public void when_part_and_manufacturer_are_not_null_then_valid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("daytona"), new Manufacturer("manu"));
		Part part = new Part("tyre");
		Car car = new Car();
		car.put(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}

	@Test
	public void when_part_is_null_then_invalid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("daytona"), new Manufacturer("manu"));
		Part part = null;
		Car car = new Car();
		car.put(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals( "must not be null",
				constraintViolations.iterator().next().getMessage() );
	}

	@Test
	public void when_manufacturer_is_null_then_invalid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("daytona"), null);
		Part part = new Part("tyre");
		Car car = new Car();
		car.put(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals( "must not be null",
				constraintViolations.iterator().next().getMessage() );
	}

	@Test
	public void when_list_of_manufacturers_is_null_then_valid() {
		List<Manufacturer> manufacturers = null;
		Part part = new Part("tyre");
		Car car = new Car();
		car.put(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}

}
