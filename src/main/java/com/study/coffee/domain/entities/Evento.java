package com.study.coffee.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEvento;

    @Column(nullable = false)
    private Integer IdEventoStatus;

    @Column(nullable = false)
    private Integer IdCategoriaEvento;

    @Column(nullable = false, length = 250)
    private String Nome;

    @Column(nullable = false)
    private Date DataHoraInicio;

    @Column(nullable = false)
    private Date DataHoraFim;
    
    @Column(nullable = false, length = 250)
    private String Local;

    @Column(nullable = false, length = 1000)
    private String Descricao;

    @Column(nullable = false)
    private Integer LimiteVagas;

} 