package com.study.coffee.service;

import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.Evento; // ENTIDADE
import com.study.coffee.repository.EventoRepository; // REPOSITÓRIO
import com.study.coffee.exception.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository EventoRepository;

    @Autowired
    public EventoService(EventoRepository EventoRepository) {
        this.EventoRepository = EventoRepository;
    }

    public Evento create(Evento model) {
        return EventoRepository.save(model);
    }

    public List<Evento> list() {
        return EventoRepository.findAll();
    }

    public Evento findById(Integer id) {
        Optional<Evento> res = EventoRepository.findById(id);
        return res.orElseThrow(() -> new DataNotFoundException("StatusEvento Not found"));
    }

    public List<String> listDistinct() {
        return EventoRepository.listDistinct();
    }

}