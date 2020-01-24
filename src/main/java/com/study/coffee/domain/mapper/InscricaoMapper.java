package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.InscricaoCreateRequest;
import com.study.coffee.domain.dto.response.InscricaoResponse;
import com.study.coffee.domain.entities.Participacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InscricaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public InscricaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public InscricaoResponse toDto(Participacao input) {
        return mapper.map(input, InscricaoResponse.class);
    }

    public Participacao fromDto(InscricaoCreateRequest input) {
        return mapper.map(input, Participacao.class);
    }
}