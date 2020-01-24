package com.study.coffee.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.study.coffee.domain.validators.DataInicioRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventoCreateRequest {

    @Value(value = "1")
    @NotNull()
    private Integer idStatusEvento;

    @NotNull()
    private Integer idCategoriaEvento;

    @Autowired
    @NotEmpty(message = "O atributo nome é obrigatório")
    private String nome;

    @DataInicioRule
    @NotNull(message = "O atributo dataInicio é obrigatório")
    private Date dataInicio;

    @NotNull(message = "O atributo dataFim é obrigatório")
    private Date dataFim;

    @Autowired
    @NotEmpty(message = "O atributo local é obrigatório")
    private String local;

    @Autowired
    @NotEmpty(message = "O atributo descricao é obrigatório")
    private String descricao;

    @Min(value = 1, message = "Deve ser maior doque ou igual a 1")
    @NotNull()
    private Integer limiteVagas;

}