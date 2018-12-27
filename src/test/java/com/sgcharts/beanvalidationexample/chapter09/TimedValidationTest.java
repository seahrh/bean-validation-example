package com.sgcharts.beanvalidationexample.chapter09;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.Duration;
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
                .clockProvider(new FixedClockProvider(now))
                .temporalValidationTolerance(Duration.ofSeconds(1))
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

    @Test
    public void given_temporal_tolerance_valid_rental() {
        ZonedDateTime startTime = now;
        ZonedDateTime endTime = startTime.plusSeconds(1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = temporalToleranceValidator.validate( r );
        assertEquals( 0, cvs.size() );
    }

    @Test
    public void when_start_time_in_tolerance_range_then_valid() {
        ZonedDateTime startTime = now.plusSeconds(1);
        ZonedDateTime endTime = startTime.plusSeconds(1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = temporalToleranceValidator.validate( r );
        assertEquals( 0, cvs.size() );
    }

    @Test
    public void when_start_time_exceeds_tolerance_range_then_invalid() {
        ZonedDateTime startTime = now.plusSeconds(2);
        ZonedDateTime endTime = startTime.plusSeconds(1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = temporalToleranceValidator.validate( r );
        assertEquals( 1, cvs.size() );
        assertEquals(
                "must be a date in the past or in the present",
                cvs.iterator().next().getMessage());
    }

    @Test
    public void when_end_time_in_tolerance_range_then_valid() {
        ZonedDateTime startTime = now;
        ZonedDateTime endTime = startTime.minusNanos(1_000_000_000 - 1);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = temporalToleranceValidator.validate( r );
        assertEquals( 0, cvs.size() );
    }

    @Test
    public void when_end_time_exceeds_tolerance_range_then_invalid() {
        ZonedDateTime startTime = now;
        ZonedDateTime endTime = startTime.minusSeconds(2);
        Rental r = new Rental(startTime, endTime);
        Set<ConstraintViolation<Rental>> cvs = temporalToleranceValidator.validate( r );
        assertEquals( 1, cvs.size() );
        assertEquals(
                "must be a future date",
                cvs.iterator().next().getMessage());
    }

}
