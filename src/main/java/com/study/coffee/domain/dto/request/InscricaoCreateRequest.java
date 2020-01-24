package com.study.coffee.domain.dto.request;

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
public class InscricaoCreateRequest {
    
    @NotNull()
    private Integer idEvento;

    @NotEmpty(message = "O atributo login é obrigatório")
    private String login;
}