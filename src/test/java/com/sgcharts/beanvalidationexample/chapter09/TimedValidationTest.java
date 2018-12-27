package com.sgcharts.beanvalidationexample.chapter09;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TimedValidationTest {

    private static Validator fixedClockValidator;
    private static Validator temporalToleranceValidator;
    private static ZonedDateTime now;

    @BeforeClass
    public static void setUp() {
        now = ZonedDateTime.of(2016, 6, 15, 0, 0, 0, 0, ZoneOffset.UTC);
        fixedClockValidator = Validation.byDefaultProvider()
                .configure()
                .clockProvider(new FixedClockProvider(now))
                .buildValidatorFactory()
                .getValidator();
        temporalToleranceValidator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .temporalValidationTolerance(Duration.ofMillis(10))
                .buildValidatorFactory()
                .getValidator();
    }

    @Test
    public void valid_rental() {
        ZonedDateTime startTime = now;
        ZonedDateTime endTime = startTime.plusSeconds(1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = fixedClockValidator.validate( r );
        assertEquals( 0, cvs.size() );
    }

    @Test
    public void given_rental_when_start_time_is_future_then_invalid() {
        ZonedDateTime startTime = now.plusSeconds(1);
        ZonedDateTime endTime = startTime.plusSeconds(1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = fixedClockValidator.validate( r );
        assertEquals( 1, cvs.size() );
        assertEquals(
                "must be a date in the past or in the present",
                cvs.iterator().next().getMessage());
    }

    @Test
    public void given_rental_when_end_time_is_present_then_invalid() {
        ZonedDateTime startTime = now;
        ZonedDateTime endTime = startTime;
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = fixedClockValidator.validate( r );
        assertEquals( 1, cvs.size() );
        assertEquals(
                "must be a future date",
                cvs.iterator().next().getMessage());
    }

    @Test
    public void given_rental_when_end_time_is_past_then_invalid() {
        ZonedDateTime startTime = now;
        ZonedDateTime endTime = startTime.minusSeconds(1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = fixedClockValidator.validate( r );
        assertEquals( 1, cvs.size() );
        assertEquals(
                "must be a future date",
                cvs.iterator().next().getMessage());
    }

}
