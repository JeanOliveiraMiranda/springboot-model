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
public class CategoriaEventoCreateRequest {

    @NotEmpty(message = "NomeCategoria is required")
    private String NomeCategoria;

    @NotEmpty(message = "IdEventoStatus status is required")
    private Integer IdCategoriaEvento;

}