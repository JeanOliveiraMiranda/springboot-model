package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.EventoCreateRequest;
import com.study.coffee.domain.dto.response.EventoResponse;
import com.study.coffee.domain.entities.Evento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public EventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EventoResponse toDto(Evento input) {
        return mapper.map(input, EventoResponse.class);
    }

    public Evento fromDto(EventoCreateRequest input) {
        return mapper.map(input, Evento.class);
    }

}