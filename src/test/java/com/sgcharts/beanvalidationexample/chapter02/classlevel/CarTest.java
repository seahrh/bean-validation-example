package com.sgcharts.beanvalidationexample.chapter02.classlevel;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CarTest {

	private static Validator validator;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void whenSeatCountEqualsPassengerCountThenValid() {
		List<Person> passengers = Arrays.asList(new Person(), new Person());
		int seatCount = 2;
		Car car = new Car(seatCount, passengers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}

	@Test
	public void whenSeatCountNotEqualsPassengerCountThenInvalid() {
		List<Person> passengers = Arrays.asList(new Person(), new Person());
		int seatCount = 1;
		Car car = new Car(seatCount, passengers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals( "seat count must equal the number of passengers.",
				constraintViolations.iterator().next().getMessage() );
	}

	@Test
	public void whenEmptyCarThenValid() {
		List<Person> passengers = new ArrayList<>();
		int seatCount = 0;
		Car car = new Car(seatCount, passengers);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}

}
