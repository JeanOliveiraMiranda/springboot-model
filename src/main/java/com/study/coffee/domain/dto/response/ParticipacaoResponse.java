package com.study.coffee.domain.dto.response;

import com.study.coffee.domain.entities.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoResponse {

    private Integer idParticipacao;

    private Evento idEvento;

    private String login;

    private short flag;

    private Integer nota;

    private String comentario;
}