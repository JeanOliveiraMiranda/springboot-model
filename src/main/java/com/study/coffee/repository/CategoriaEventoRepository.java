package com.study.coffee.repository;

import java.util.List;

import com.study.coffee.domain.entities.CategoriaEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Integer> {

    @Query(nativeQuery = true, value = "select distinct NomeCategoria from CategoriaEvento")
    List<String> listDistinct();

}