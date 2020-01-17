package com.study.coffee.service;

import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.repository.CategoriaEventoRepository;
import com.study.coffee.exception.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEventoService {

    private final CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    public CategoriaEvento create(CategoriaEvento model) {
        return categoriaEventoRepository.save(model);
    }

    public List<CategoriaEvento> list() {
        return categoriaEventoRepository.findAll();
    }

    public CategoriaEvento findById(Integer id) {
        Optional<CategoriaEvento> res = categoriaEventoRepository.findById(id);
        return res.orElseThrow(() -> new DataNotFoundException("StatusEvento Not found"));
    }

    public List<String> listDistinct() {
        return categoriaEventoRepository.listDistinct();
    }

}