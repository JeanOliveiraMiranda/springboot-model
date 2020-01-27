package com.study.coffee.domain.dto.response;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfirmacaoResponse {

    @NotEmpty(message = "O atributo login é obrigatório")
    private short flag;
}