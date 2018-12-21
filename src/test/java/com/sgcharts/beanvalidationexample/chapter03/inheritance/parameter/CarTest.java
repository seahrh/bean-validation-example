package com.sgcharts.beanvalidationexample.chapter03.inheritance.parameter;

import java.lang.reflect.Method;
import javax.validation.ConstraintDeclarationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

	private static ExecutableValidator executableValidator;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		executableValidator = factory.getValidator().forExecutables();
	}

	@Test(expected = ConstraintDeclarationException.class)
	public void illegalParameterConstraints() throws Exception {
		Car object = new Car();
		Method method = Car.class.getMethod( "drive", int.class );
		Object[] parameterValues = { };
		executableValidator.validateParameters(
				object,
				method,
				parameterValues
		);
	}
}
