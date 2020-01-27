package com.study.coffee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.study.coffee.domain.entities.Evento;

import org.springframework.stereotype.Repository;

@Repository
public class CustomRepository {
    @PersistenceContext
    protected EntityManager manager;

    public List<Evento> findData(String query) {
        return manager.createNativeQuery(query, Evento.class).getResultList();
    }

}