package com.study.coffee.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.study.coffee.configuration.MapperConfig;
import com.study.coffee.domain.dto.request.StatusEventoCreateRequest;
import com.study.coffee.domain.dto.response.StatusEventoResponse;
import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.domain.mapper.StatusEventoMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * StatusEventoMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private StatusEventoMapper mapper;

    @Test
    public void shouldConvertStatusEventoToStatusEventoResponse() {

        StatusEvento entity = StatusEvento.builder().idStatusEvento(1).nome("Aberto para Inscrições").build();
        StatusEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdStatusEvento(), entity.getIdStatusEvento());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
    }

    @Test
    public void shouldConvertStatusEventoCreateRequestToStatusEvento() {
        StatusEventoCreateRequest dto = StatusEventoCreateRequest.builder().nome("Aberto para Inscrições").build();

        StatusEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
    }

}