package com.study.coffee.domain.dto.response;

import com.study.coffee.domain.entities.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscricaoResponse {

    private String login;
}