package com.study.coffee.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.study.coffee.domain.entities.Evento;

// import com.study.coffee.domain.entities.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoCreateRequest {

    @NotNull()
    private Evento idEvento;

    @NotEmpty()
    private String login;

    @NotNull()
    private short flag;

    @NotNull()
    private Integer nota;

    @NotEmpty()
    private String comentario;
}