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
        Optional<Participacao> participacao = participacaoRepository.findById(id);
        return participacao.orElseThrow(() -> new DataNotFoundException("Participacao Not found"));
    }

    public List<String> listDistinct() {
        return participacaoRepository.listDistinct();
    }

    public Participacao update(Integer id, Participacao model) {
        Optional<Participacao> participacao = participacaoRepository.findById(id);

        // atualiza o model
        model.setIdParticipacao(id);

        // atualiza o banco de dados
        participacaoRepository.save(model);

        // retorna participacao
        return participacao.orElseThrow(() -> new DataNotFoundException("Participacao not found"));
    }

    public Participacao deleteParticipacao(Integer id){
        // verifica se id existe
        Optional<Participacao> participacao = participacaoRepository.findById(id);

        participacaoRepository.deleteById(id);

        return participacao.orElseThrow(() -> new DataNotFoundException("Participação não encontrada"));
    }

}