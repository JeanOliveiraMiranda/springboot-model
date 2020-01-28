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
 * EventoCreateRequestTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoCreateRequestTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_NotBeValid_WhenLimiteVagas0() {

        Date date = new Date();

        EventoCreateRequest createDto = EventoCreateRequest.builder().idStatusEvento(1).idCategoriaEvento(1)
                .nome("Meetup Frontend").dataInicio(date).dataFim(date).local("Faria Lima").descricao("Evento FLutter")
                .limiteVagas(0).build();

        Set<ConstraintViolation<EventoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertTrue("Modelo deve ser inválido", constraintViolations.size() > 0);
    }

    @Test
    public void should_NotBeValid_WhenDateIsSameDay() {

        Date date = new Date();

        EventoCreateRequest createDto = EventoCreateRequest.builder().idStatusEvento(1).idCategoriaEvento(1)
                .nome("Meetup Frontend").dataInicio(date).dataFim(date).local("Faria Lima").descricao("Evento FLutter")
                .limiteVagas(50).build();

        Set<ConstraintViolation<EventoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertTrue("Modelo deve ser inválido", constraintViolations.size() > 0);
    }

    @Test
    public void should_BeValid() {

        Date hoje = new Date();
        Calendar date = Calendar.getInstance();

        date.setTime(hoje);

        date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) + 1);

        EventoCreateRequest createDto = EventoCreateRequest.builder().idStatusEvento(1).idCategoriaEvento(1)
                .nome("Meetup Frontend").dataInicio(date.getTime()).dataFim(date.getTime()).local("Faria Lima")
                .descricao("Evento FLutter").limiteVagas(50).build();

        Set<ConstraintViolation<EventoCreateRequest>> constraintViolations = validator.validate(createDto);

        assertEquals("Modelo deve ser válido", constraintViolations.size(), 0);
    }

}