package com.study.coffee.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdParticipacao")
    private Integer idParticipacao;

    @ManyToOne
    @JoinColumn(name = "IdEvento", nullable = false)
    private Evento idEvento;

    @Column(name = "LoginParticipante", nullable = false, length = 250)
    private String login;

    @Column(name = "FlagPresente", nullable = false, columnDefinition = "BIT")
    private short flag;

    @Column(name = "Nota", nullable = false)
    private Integer nota;

    @Column(name = "Comentario", nullable = false, length = 1000)
    private String comentario;
}