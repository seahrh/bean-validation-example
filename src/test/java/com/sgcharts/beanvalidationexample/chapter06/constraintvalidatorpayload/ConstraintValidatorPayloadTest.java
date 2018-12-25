package com.sgcharts.beanvalidationexample.chapter06.constraintvalidatorpayload;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ConstraintValidatorPayloadTest {

    private static Validator validatorUs;
    private static Validator validatorFr;

    @BeforeClass
    public static void setUp() {
        validatorUs = Validation.byProvider(HibernateValidator.class)
                .configure()
                .constraintValidatorPayload("US")
                .buildValidatorFactory().getValidator();
        validatorFr = Validation.byProvider(HibernateValidator.class)
                .configure()
                .constraintValidatorPayload("FR")
                .buildValidatorFactory().getValidator();
    }

    @Test
    public void valid_us_zip_code() {
        Address in = new Address("123456");
        Set<ConstraintViolation<Address>> cvs = validatorUs.validate(in);
        assertEquals(0, cvs.size());
    }

    @Test
    public void given_us_zip_code_when_incorrect_length_then_invalid() {
        Address in = new Address("12345");
        Set<ConstraintViolation<Address>> cvs = validatorUs.validate(in);
        assertEquals(1, cvs.size());
        assertEquals(
                "invalid zip code",
                cvs.iterator().next().getMessage()
        );
    }

    @Test
    public void valid_fr_zip_code() {
        Address in = new Address("12345");
        Set<ConstraintViolation<Address>> cvs = validatorFr.validate(in);
        assertEquals(0, cvs.size());
    }

    @Test
    public void given_fr_zip_code_when_incorrect_length_then_invalid() {
        Address in = new Address("123456");
        Set<ConstraintViolation<Address>> cvs = validatorFr.validate(in);
        assertEquals(1, cvs.size());
        assertEquals(
                "invalid zip code",
                cvs.iterator().next().getMessage()
        );
    }
}
