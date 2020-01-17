package com.study.coffee.domain.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventoResponse {

    private Integer id;

    private Integer id_evento_status;

    private Integer id_categoria_evento;

    private String nome;

    private Date data_inicio;

    private Date data_fim;

    private String local;

    private String descricao;

    private Integer limite_vagas;

}