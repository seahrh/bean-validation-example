package com.sgcharts.beanvalidationexample.chapter02.objectgraph.containerelement;

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
import static org.junit.Assert.assertTrue;

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
	public void when_all_associated_objects_are_valid_then_valid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), new Manufacturer("michelin"));
		Part part = new Part("tyre");
		Person passenger = new Person("john");
		Car car = new Car();
		car.addPassenger(passenger);
		car.addPart(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void when_passenger_is_null_then_invalid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), new Manufacturer("michelin"));
		Part part = new Part("tyre");
		Car car = new Car();
		car.addPassenger(null);
		car.addPart(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(1, constraintViolations.size());
		ConstraintViolation cv = constraintViolations.iterator().next();
		assertEquals("passengers[0].<list element> must not be null",
				cv.getPropertyPath() + " " + cv.getMessage());
	}

	@Test
	public void when_passenger_is_invalid_then_invalid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), new Manufacturer("michelin"));
		Part part = new Part("tyre");
		Person passenger = new Person(null);
		Car car = new Car();
		car.addPassenger(passenger);
		car.addPart(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(1, constraintViolations.size());
		ConstraintViolation cv = constraintViolations.iterator().next();
		assertEquals("passengers[0].name must not be null",
				cv.getPropertyPath() + " " + cv.getMessage());

	}

	@Test
	public void when_part_is_invalid_then_invalid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), new Manufacturer("michelin"));
		Part part = new Part(null);
		Person passenger = new Person("foo");
		Car car = new Car();
		car.addPassenger(passenger);
		car.addPart(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(1, constraintViolations.size());
		ConstraintViolation cv = constraintViolations.iterator().next();
		assertTrue((cv.getPropertyPath() + " " + cv.getMessage()).endsWith(".name must not be null"));
	}

	@Test
	public void when_manufacturer_is_invalid_then_invalid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), new Manufacturer(null));
		Part part = new Part("tyre");
		Person passenger = new Person("foo");
		Car car = new Car();
		car.addPassenger(passenger);
		car.addPart(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(1, constraintViolations.size());
		ConstraintViolation cv = constraintViolations.iterator().next();
		assertTrue((cv.getPropertyPath() + " " + cv.getMessage()).endsWith(".name must not be null"));
	}

	@Test
	public void when_manufacturer_is_null_then_valid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), null);
		Part part = new Part("tyre");
		Person passenger = new Person("foo");
		Car car = new Car();
		car.addPassenger(passenger);
		car.addPart(part, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void when_part_is_null_then_valid() {
		List<Manufacturer> manufacturers = Arrays.asList(
				new Manufacturer("goodyear"), new Manufacturer("michelin"));
		Person passenger = new Person("foo");
		Car car = new Car();
		car.addPassenger(passenger);
		car.addPart(null, manufacturers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(0, constraintViolations.size());
	}
}