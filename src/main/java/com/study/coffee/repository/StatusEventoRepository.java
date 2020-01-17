package com.study.coffee.repository;

import java.util.List;

import com.study.coffee.domain.entities.StatusEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEventoRepository extends JpaRepository<StatusEvento, Integer> {

    @Query(nativeQuery = true, value = "select distinct name from Client")
    List<String> listDistinct();

}