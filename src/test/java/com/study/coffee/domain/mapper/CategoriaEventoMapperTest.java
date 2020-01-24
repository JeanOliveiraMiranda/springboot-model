package com.study.coffee.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.study.coffee.configuration.MapperConfig;
import com.study.coffee.domain.dto.request.CategoriaEventoCreateRequest;
import com.study.coffee.domain.dto.response.CategoriaEventoResponse;
import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.mapper.CategoriaEventoMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * CategoriaEventoMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private CategoriaEventoMapper mapper;

    @Test
    public void shouldConvertCategoriaEventoToCategoriaEventoResponse() {

        CategoriaEvento entity = CategoriaEvento.builder().idCategoriaEvento(1).nome("Backend").build();
        CategoriaEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdCategoriaEvento(), entity.getIdCategoriaEvento());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
    }

    @Test
    public void shouldConvertCategoriaEventoRequestToCategoriaEvento() {
        CategoriaEventoCreateRequest dto = CategoriaEventoCreateRequest.builder().nome("Backend").build();

        CategoriaEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
    }

}