package com.study.coffee.service;

import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.StatusEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusEventoService {

    private final StatusEventoRepository statusEventoRepository;

    @Autowired
    public StatusEventoService(StatusEventoRepository statusEventoRepository) {
        this.statusEventoRepository = statusEventoRepository;
    }

    public StatusEvento create(StatusEvento model) {
        return statusEventoRepository.save(model);
    }

    public List<StatusEvento> list() {
        return statusEventoRepository.findAll();
    }

    public StatusEvento findById(Integer id) {
        Optional<StatusEvento> res = statusEventoRepository.findById(id);
        return res.orElseThrow(() -> new DataNotFoundException("StatusEvento Not found"));
    }

    public List<String> listDistinct() {
        return statusEventoRepository.listDistinct();
    }

    public StatusEvento update(Integer id, StatusEvento model) {
        Optional<StatusEvento> statusEvento = statusEventoRepository.findById(id);

        model.setIdStatusEvento(id);
        model.setNome(model.getNome().toUpperCase());

        statusEventoRepository.save(model);

        return statusEvento.orElseThrow(() -> new DataNotFoundException("Client Not found"));

    }

    
    public StatusEvento deleteStatusEvento(Integer id) {
        Optional<StatusEvento> statusEvento = statusEventoRepository.findById(id);

        statusEventoRepository.deleteById(id);

        return statusEvento.orElseThrow(() -> new DataNotFoundException("Client Not found"));

    }

}