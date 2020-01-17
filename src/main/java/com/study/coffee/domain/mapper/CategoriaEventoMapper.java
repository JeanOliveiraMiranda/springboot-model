package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.CategoriaEventoCreateRequest;
import com.study.coffee.domain.dto.response.CategoriaEventoResponse;
import com.study.coffee.domain.entities.CategoriaEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public CategoriaEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CategoriaEventoResponse toDto(CategoriaEvento input) {
        return mapper.map(input, CategoriaEventoResponse.class);
    }

    public CategoriaEvento fromDto(CategoriaEventoCreateRequest input) {
        return mapper.map(input, CategoriaEvento.class);
    }

}