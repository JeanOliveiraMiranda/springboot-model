package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.ParticipacaoCreateRequest;
import com.study.coffee.domain.dto.response.ParticipacaoResponse;
import com.study.coffee.domain.entities.Participacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipacaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public ParticipacaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ParticipacaoResponse toDto(Participacao input) {
        return mapper.map(input, ParticipacaoResponse.class);
    }

    public Participacao fromDto(ParticipacaoCreateRequest input) {
        return mapper.map(input, Participacao.class);
    }

}