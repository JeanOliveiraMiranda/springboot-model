package com.study.coffee.domain.dto.validators;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;

import javax.validation.ConstraintValidatorContext;
import com.study.coffee.domain.validators.DataInicioRuleValidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * PhoneValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DataInicioRuleValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    DataInicioRuleValidator dataInicioRuleValidator;

    @Before
    public void setUp() {

        dataInicioRuleValidator = new DataInicioRuleValidator();

    }

    @Test
    public void should_NotBeValid_WhenExactDate() {
        Date hoje = new Date();

        assertFalse(dataInicioRuleValidator.isValid(hoje, constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenDayIsBefore() {
        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);
        date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) - 1);

        assertFalse(dataInicioRuleValidator.isValid(date.getTime(), constraintValidatorContext));

    }

    @Test
    public void should_NotBeValid_WhenMonthIsBefore() {
        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);
        date.set(Calendar.MONTH, date.get(Calendar.MONTH) - 1);

        assertFalse(dataInicioRuleValidator.isValid(date.getTime(), constraintValidatorContext));

    }

    @Test
    public void should_NotBeValid_WhenYearIsBefore() {
        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);
        date.set(Calendar.YEAR, date.get(Calendar.YEAR) - 1);

        assertFalse(dataInicioRuleValidator.isValid(date.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_WhenDayIsAfter() {
        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);
        date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) + 1);

        assertTrue(dataInicioRuleValidator.isValid(date.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_WhenMonthIsAfter() {
        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);
        date.set(Calendar.MONTH, date.get(Calendar.MONTH) + 1);

        assertTrue(dataInicioRuleValidator.isValid(date.getTime(), constraintValidatorContext));
    }
  
    @Test
    public void should_NotBeValid_WhenYearIsAfter() {
        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);
        date.set(Calendar.YEAR, date.get(Calendar.YEAR) + 1);

        assertTrue(dataInicioRuleValidator.isValid(date.getTime(), constraintValidatorContext));
    }
}