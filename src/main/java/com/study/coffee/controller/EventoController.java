package com.study.coffee.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.study.coffee.domain.dto.request.EventoCreateRequest;
import com.study.coffee.domain.dto.response.EventoResponse;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.mapper.EventoMapper;
import com.study.coffee.service.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final EventoService eventoService;
    private final EventoMapper mapper;

    @Autowired
    public EventoController(EventoService eventoService, EventoMapper eventoMapper) {
        this.eventoService = eventoService;
        this.mapper = eventoMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(eventoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<EventoResponse>> list() {
        return ResponseEntity.ok(eventoService.list().stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/distinct")
    public ResponseEntity<List<String>> listDistinct() {
        return ResponseEntity.ok(eventoService.listDistinct());
    }

    @PostMapping
    public ResponseEntity<EventoResponse> post(@Valid @RequestBody EventoCreateRequest model) {

        Evento statusEvento = eventoService.create(mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(statusEvento));
    }

}