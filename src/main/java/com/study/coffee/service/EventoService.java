package com.study.coffee.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento; // ENTIDADE
import com.study.coffee.repository.EventoRepository; // REPOSITÓRIO
import com.study.coffee.exception.DataBadRequestException;
import com.study.coffee.exception.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento create(Evento model) {

        Date dataInicio = model.getDataInicio();
        Date dataFim = model.getDataFim();
        // Função que retorna se a dataFim está no mesmo dia -- LÓGICA DATAFIM
        Boolean isValid = dataFimMesmoDia(dataFim, dataInicio);

        if (isValid) {
            return eventoRepository.save(model);

        } else {
            throw new DataBadRequestException("A dataFim: " + dataFim
                    + " é inválida. Selecione uma dataFim que seja no mesmo dia da dataInico: " + dataInicio);
        }

    }

    public List<Evento> list() {
        return eventoRepository.findAll();
    }

    public Evento findById(Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElseThrow(() -> new DataNotFoundException("StatusEvento Not found"));
    }

    public Evento updateEvento(Integer id, Evento model) {
        Optional<Evento> evento = eventoRepository.findById(id);

        model.setIdEvento(id);

        Date dataInicio = model.getDataInicio();
        Date dataFim = model.getDataFim();

        // Função que retorna se a dataFim está no mesmo dia
        Boolean isValid = dataFimMesmoDia(dataFim, dataInicio);

        if (evento.isPresent()) {
            if (isValid) {
                return eventoRepository.save(model);
            } else {
                throw new DataNotFoundException("A data:" + dataFim
                        + " é inválida. Selecione uma dataFim que seja no mesmo dia da dataInico:" + dataInicio);
            }
        }

        return evento.orElseThrow(() -> new DataNotFoundException("Evento" + id + "not encontrado"));

    }

    public Evento deleteEvento(Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);

        eventoRepository.deleteById(id);

        return evento.orElseThrow(() -> new DataNotFoundException("Evento" + id + "not encontrado"));
    }

    public List<Evento> listByIdCategoria(CategoriaEvento idCategoriaEvento, Date dataInicio) {

        List<Evento> eventoByCategoria = eventoRepository.findByIdCategoriaEvento(idCategoriaEvento);
        List<Evento> eventoByData = eventoRepository.findByDataInicio(dataInicio);

        List<Evento> newList = new ArrayList<Evento>(eventoByCategoria);
        newList.addAll(eventoByData);

        return newList;
    }

    public static Boolean dataFimMesmoDia(Date dataFim, Date dataInicio) {

        // Vai ser retornado nessa função
        Boolean isTrue = false;
        // Criando Instancia do Calendar
        Calendar dataInicioCalendar = Calendar.getInstance();
        Calendar dataFimCalendar = Calendar.getInstance();

        // Setando os calores do Calendar com as datas do parametro
        dataInicioCalendar.setTime(dataInicio);
        dataFimCalendar.setTime(dataFim);

        // Declarando variaveis de verificação da data a ser comparada
        int dataInicioDia = dataInicioCalendar.get(Calendar.DAY_OF_MONTH);
        int dataInicioMes = dataInicioCalendar.get(Calendar.MONTH);
        int dataInicioAno = dataInicioCalendar.getWeekYear();

        // Declarando variaveis de verificação da dataFim
        int dataFimoDia = dataFimCalendar.get(Calendar.DAY_OF_MONTH);
        int dataFimMes = dataFimCalendar.get(Calendar.MONTH);
        int dataFimAno = dataFimCalendar.getWeekYear();

        // Verificar
        if (dataInicioDia == dataFimoDia && dataInicioMes == dataFimMes && dataInicioAno == dataFimAno) {
            System.out.println("Mesmo dia");
            isTrue = true;
        } else {
            isTrue = false;
        }

        return isTrue;

    }

}