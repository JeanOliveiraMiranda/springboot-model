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
public class StatusEventoCreateRequest {

    @NotEmpty(message = "O atributo nome é obrigatório")
    private String nome;

}