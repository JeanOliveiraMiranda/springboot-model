package com.study.coffee.repository;

import com.study.coffee.domain.entities.StatusEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEventoRepository extends JpaRepository<StatusEvento, Integer> {


}