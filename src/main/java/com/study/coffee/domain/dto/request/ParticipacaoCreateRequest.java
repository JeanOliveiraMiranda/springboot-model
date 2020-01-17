package com.study.coffee.domain.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoCreateRequest {

    @NotEmpty()
    private Integer id_evento;

    @NotEmpty()
    private String login;

    @NotEmpty()
    private short flag;

    @NotEmpty()
    private Integer nota;

    @NotEmpty()
    private String comentario;
}