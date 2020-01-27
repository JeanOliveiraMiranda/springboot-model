package com.study.coffee.repository;

import java.util.Date;
import java.util.List;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findByIdCategoriaEvento(CategoriaEvento idCategoriaEvento);

    List<Evento> findByDataInicio(Date dataInicio);

}