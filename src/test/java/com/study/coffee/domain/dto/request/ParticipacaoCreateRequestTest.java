package com.study.coffee.domain.dto.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.study.coffee.domain.entities.StatusEvento;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ParticipacaoCreateRequestTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoCreateRequestTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_NotBeValid_WhenNotaIsInvalid() {

        ParticipacaoCreateRequest createDto = ParticipacaoCreateRequest.builder().idEvento(1).login(null)
                .flag((short) 0).nota(-10).comentario("Evento tópi, gostei demais, continuem assim galera o/").build();

        Set<ConstraintViolation<ParticipacaoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertTrue("Modelo deve ser inválido", constraintViolations.size() > 0);
    }

    @Test
    public void should_NotBeValid_WhenLoginIsInvalid() {

        ParticipacaoCreateRequest createDto = ParticipacaoCreateRequest.builder().idEvento(1).login(null)
                .flag((short) 0).nota(10).comentario("Evento tópi, gostei demais, continuem assim galera o/").build();

        Set<ConstraintViolation<ParticipacaoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertTrue("Modelo deve ser inválido", constraintViolations.size() > 0);
    }

    @Test
    public void should_BeValid() {

        ParticipacaoCreateRequest createDto = ParticipacaoCreateRequest.builder().idEvento(1)
                .login("jean.miranda@iteris.com.br").flag((short) 0).nota(10)
                .comentario("Evento tópi, gostei demais, continuem assim galera o/").build();

        Set<ConstraintViolation<ParticipacaoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertEquals("Modelo deve ser válido", constraintViolations.size(), 0);
    }

}