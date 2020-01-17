package com.study.coffee.service;

import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.Participacao;
import com.study.coffee.repository.ParticipacaoRepository;
import com.study.coffee.exception.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository) {
        this.participacaoRepository = participacaoRepository;
    }

    public Participacao create(Participacao model) {
        return participacaoRepository.save(model);
    }

    public List<Participacao> list() {
        return participacaoRepository.findAll();
    }

    public Participacao findById(Integer id) {
        Optional<Participacao> res = participacaoRepository.findById(id);
        return res.orElseThrow(() -> new DataNotFoundException("Participacao Not found"));
    }

    public List<String> listDistinct() {
        return participacaoRepository.listDistinct();
    }

}