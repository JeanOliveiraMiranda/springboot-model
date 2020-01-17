package com.study.coffee.repository;

import java.util.List;

import com.study.coffee.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query(nativeQuery = true, value = "select distinct Nome from Evento")
    List<String> listDistinct();

}