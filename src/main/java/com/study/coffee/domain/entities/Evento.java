package com.study.coffee.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEvento", nullable = false, unique = true)
    private Integer idEvento;

    @ManyToOne
    @JoinColumn(name = "IdEventoStatus", nullable = false)
    private StatusEvento idStatusEvento;

    @ManyToOne
    @JoinColumn(name = "IdCategoriaEvento", nullable = false)
    private CategoriaEvento idCategoriaEvento;

    @Column(name = "Nome", nullable = false, length = 250)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DataHoraInicio", nullable = false, columnDefinition = "DATETIME")
    private Date dataInicio;

    @Column(name = "DataHoraFim", nullable = false)
    private Date dataFim;

    @Column(name = "Local", nullable = false, length = 250)
    private String local;

    @Column(name = "Descricao", nullable = false, length = 1000)
    private String descricao;

    @Column(name = "LimiteVagas", nullable = false)
    private Integer limiteVagas;

}