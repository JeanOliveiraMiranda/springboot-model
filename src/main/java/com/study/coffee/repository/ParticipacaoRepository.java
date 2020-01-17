package com.study.coffee.repository;

import java.util.List;

import com.study.coffee.domain.entities.Participacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

    @Query(nativeQuery = true, value = "select distinct LoginParticipante from Participacao")
    List<String> listDistinct();

}