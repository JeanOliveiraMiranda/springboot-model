package com.study.coffee.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findByIdCategoriaEvento(CategoriaEvento idCategoriaEvento);

    // // List<Evento> findByDataInicio(Date dataInicio);

    @Query(nativeQuery = true, value = "Select * from Evento where DataHoraInicio < '2020-01-26'")
    public List<Evento> filterByData(Date dataInicio);
    // @Query(value = "Select * from Evento where DataHoraInicio < ?1", nativeQuery
    // = true)

}