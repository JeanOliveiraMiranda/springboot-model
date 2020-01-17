package com.study.coffee.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventoCreateRequest {

    @NotEmpty()
    private int IdEventoStatus;

    @NotEmpty()
    private int IdCategoriaEvento;

    @NotEmpty()
    private String Nome;

    @NotEmpty()
    private Date DataHoraInicio;

    @NotEmpty()
    private Date DataHoraFim;

    @NotEmpty()
    private String Local;

    @NotEmpty()
    private String Descricao;

    @NotEmpty()
    private int LimiteVagas;

}