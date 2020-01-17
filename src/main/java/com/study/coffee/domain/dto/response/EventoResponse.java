package com.study.coffee.domain.dto.response;

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

public class EventoResponse {

    private int IdEvento;

    private int IdEventoStatus;

    private int IdCategoriaEvento;

    private String Nome;

    private Date DataHoraInicio;

    private Date DataHoraFim;

    private String Local;

    private String Descricao;

    private int LimiteVagas;

}