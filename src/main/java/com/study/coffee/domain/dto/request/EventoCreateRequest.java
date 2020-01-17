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
    private Integer id_evento_status;

    @NotEmpty()
    private Integer id_categoria_evento;

    @NotEmpty()
    private String nome;

    @NotEmpty()
    private Date data_inicio;

    @NotEmpty()
    private Date data_fim;

    @NotEmpty()
    private String local;

    @NotEmpty()
    private String descricao;

    @NotEmpty()
    private Integer limite_vagas;

}