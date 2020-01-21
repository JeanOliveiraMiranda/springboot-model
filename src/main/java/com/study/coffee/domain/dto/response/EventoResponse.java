package com.study.coffee.domain.dto.response;

import java.util.Date;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.StatusEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventoResponse {

    private Integer idEvento;

    private StatusEvento idStatusEvento;

    private CategoriaEvento idCategoriaEvento;

    private String nome;

    private Date dataInicio;

    private Date dataFim;

    private String local;

    private String descricao;

    private Integer limiteVagas;

}