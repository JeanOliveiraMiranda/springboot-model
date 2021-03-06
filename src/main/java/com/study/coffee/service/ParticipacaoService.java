package com.study.coffee.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.entities.Participacao;
import com.study.coffee.repository.EventoRepository;
import com.study.coffee.repository.ParticipacaoRepository;
import com.study.coffee.exception.DataBadRequestException;
import com.study.coffee.exception.DataForbiddenException;
import com.study.coffee.exception.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;
    private final EventoRepository eventoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository, EventoRepository eventoRepository) {
        this.participacaoRepository = participacaoRepository;
        this.eventoRepository = eventoRepository;

    }

    public Participacao create(Participacao model) {
        return participacaoRepository.save(model);
    }

    public List<Participacao> list() {
        return participacaoRepository.findAll();
    }

    public Participacao inscrever(Participacao model) {
        Optional<Evento> evento = eventoRepository.findById(model.getIdEvento().getIdEvento());

        Date hoje = new Date();
        Date dataInicio = evento.get().getDataInicio();

        if (dataInicio.after(hoje)) {
            return participacaoRepository.save(model);
        } else {
            throw new DataBadRequestException("Só pode se inscrever em eventos futuros");
        }
    }

    public Participacao confirmacaoEvento(Integer id, Participacao model) {
        Optional<Participacao> participacao = participacaoRepository.findById(id);

        // Setando ID da participação
        model.setIdParticipacao(id);

        // atualizando os demais para o mesmo
        model.setIdEvento(participacao.get().getIdEvento());
        model.setComentario(participacao.get().getComentario());
        model.setLogin(participacao.get().getLogin());
        model.setNota(participacao.get().getNota());
        // atualiza o model

        Date date = participacao.get().getIdEvento().getDataInicio();
        Integer idStatusEvento = participacao.get().getIdEvento().getIdStatusEvento().getIdStatusEvento();
        if (date.after(new Date())) {
            throw new DataForbiddenException("Você não pode editar em eventos futuros");
        } else {
            if (idStatusEvento == 3 || idStatusEvento == 4) {
                participacaoRepository.save(model);

            } else {
                throw new DataForbiddenException("O evento precisa estar concluído para poder confirmar participação");
            }
        }

        return participacao.orElseThrow(() -> new DataNotFoundException("Participacao not found"));
    }

    public Participacao findById(Integer id) {
        Optional<Participacao> participacao = participacaoRepository.findById(id);

        return participacao.orElseThrow(() -> new DataNotFoundException("Participacao Not found"));
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

    public Participacao deleteParticipacao(Integer id) {
        // verifica se id existe
        Optional<Participacao> participacao = participacaoRepository.findById(id);

        participacaoRepository.deleteById(id);

        return participacao.orElseThrow(() -> new DataNotFoundException("Participação não encontrada"));
    }

}