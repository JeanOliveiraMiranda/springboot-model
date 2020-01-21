package com.study.coffee.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventoCreateRequest {

    @NotNull()
    private Integer idStatusEvento;

    @NotNull()
    private Integer idCategoriaEvento;

    @NotEmpty()
    private String nome;

    @NotNull()
    private Date dataInicio;

    @NotNull()
    private Date dataFim;

    @NotEmpty()
    private String local;

    @NotEmpty()
    private String descricao;

    @NotNull()
    private Integer limiteVagas;

}