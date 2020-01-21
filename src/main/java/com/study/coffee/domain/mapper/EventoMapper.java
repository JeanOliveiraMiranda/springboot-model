package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.EventoCreateRequest;
import com.study.coffee.domain.dto.response.EventoResponse;
import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.entities.StatusEvento;

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

    // public Evento fromDto(EventoCreateRequest input) {
    // return mapper.map(input, Evento.class);
    // }

    public Evento fromDto(EventoCreateRequest input) {

        Evento model = mapper.map(input, Evento.class);

        StatusEvento statusEvento = new StatusEvento();
        CategoriaEvento categoriaEvento = new CategoriaEvento();

        statusEvento.setIdStatusEvento(input.getIdStatusEvento());
        categoriaEvento.setIdCategoriaEvento(input.getIdCategoriaEvento());
        
        model.setIdStatusEvento(statusEvento);
        model.setIdCategoriaEvento(categoriaEvento);

        return model;
    }
}