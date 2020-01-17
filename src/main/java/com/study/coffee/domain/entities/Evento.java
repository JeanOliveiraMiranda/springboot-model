package com.study.coffee.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEvento")
    private Integer id;

    // @OneToMany(mappedBy = "StatusEvento")
    @Column(name = "IdEventoStatus", nullable = false)
    private Integer id_evento_status;

    // @OneToMany(mappedBy = "CategoriaEvento")
    @Column(name = "IdCategoriaEvento", nullable = false)
    private Integer id_categoria_evento;

    @Column(name = "Nome", nullable = false, length = 250)
    private String nome;

    @Column(name = "DataHoraInicio", nullable = false)
    private Date data_inicio;

    @Column(name = "DataHoraFim", nullable = false)
    private Date data_fim;

    @Column(name = "Local", nullable = false, length = 250)
    private String local;

    @Column(name = "Descricao", nullable = false, length = 1000)
    private String descricao;

    @Column(name="LimiteVagas", nullable = false)
    private Integer limite_vagas;

}