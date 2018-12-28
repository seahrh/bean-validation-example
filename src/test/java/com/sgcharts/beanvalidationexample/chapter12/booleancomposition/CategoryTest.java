package com.sgcharts.beanvalidationexample.chapter12.booleancomposition;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void when_both_pattern_and_size_are_valid_then_category_is_valid() {
		Category c = new Category("abc");
		Set<ConstraintViolation<Category>> cvs = validator.validate( c );
		assertEquals( 0, cvs.size() );
	}

	@Test
	public void when_pattern_is_valid_but_size_is_invalid_then_category_is_valid() {
		Category c = new Category("a");
		Set<ConstraintViolation<Category>> cvs = validator.validate( c );
		assertEquals( 0, cvs.size() );
	}

	@Test
	public void when_pattern_is_invalid_but_size_is_valid_then_category_is_valid() {
		Category c = new Category("123");
		Set<ConstraintViolation<Category>> cvs = validator.validate(c);
		assertEquals(0, cvs.size());
	}

	@Test
	public void when_both_pattern_and_size_are_invalid_then_category_is_invalid() {
		Category c = new Category("1234");
		Set<ConstraintViolation<Category>> cvs = validator.validate(c);
		assertEquals(1, cvs.size());
		assertEquals(
				"both pattern and size are invalid",
				cvs.iterator().next().getMessage()
		);
	}
}
