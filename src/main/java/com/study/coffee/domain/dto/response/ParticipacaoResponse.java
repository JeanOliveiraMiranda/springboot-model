package com.study.coffee.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoResponse {

    private Integer id;

    private Integer id_evento;

    private String login;

    private short flag;

    private Integer nota;

    private String comentario;
}