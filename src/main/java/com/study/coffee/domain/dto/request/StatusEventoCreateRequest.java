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

    @NotEmpty(message = "nome is required")
    private String nome;

    @NotEmpty(message = "IdEventoStatus status is required")
    private String idStatusEvento;

}