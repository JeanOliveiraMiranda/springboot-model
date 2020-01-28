package com.study.coffee.domain.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * StatusEventoCreateRequestTest
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusEventoCreateRequestTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_NotBeValid_WhenNomeIsInvalid() {
        StatusEventoCreateRequest createDto = StatusEventoCreateRequest.builder().nome(null).build();

        Set<ConstraintViolation<StatusEventoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertTrue("Modelo deve ser inválido", constraintViolations.size() > 0);
    }

    @Test
    public void should_BeValid() {

        StatusEventoCreateRequest createDto = StatusEventoCreateRequest.builder().nome("Em andamento").build();

        Set<ConstraintViolation<StatusEventoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertEquals("Modelo deve ser válido", constraintViolations.size(), 0);
    }

} 