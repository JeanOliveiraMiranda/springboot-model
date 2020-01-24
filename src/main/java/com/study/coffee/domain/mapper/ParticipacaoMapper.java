package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.InscricaoCreateRequest;
import com.study.coffee.domain.dto.request.ParticipacaoCreateRequest;
import com.study.coffee.domain.dto.response.InscricaoResponse;
import com.study.coffee.domain.dto.response.ParticipacaoResponse;
import com.study.coffee.domain.entities.Evento;
// import com.study.coffee.domain.entities.Evento;
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

        Participacao model = mapper.map(input, Participacao.class);
        Evento evento = new Evento();

        evento.setIdEvento(input.getIdEvento());
        model.setIdEvento(evento);

        return model;
    }

    public Participacao fromDtoInsc(InscricaoCreateRequest input) {
        Participacao model = mapper.map(input, Participacao.class);
        Evento evento = new Evento();

        evento.setIdEvento(input.getIdEvento());
        model.setIdEvento(evento);

        return model;
    }
}