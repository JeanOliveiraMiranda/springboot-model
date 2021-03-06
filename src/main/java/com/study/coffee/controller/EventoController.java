package com.study.coffee.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.study.coffee.domain.dto.request.EventoCreateRequest;
import com.study.coffee.domain.dto.response.EventoResponse;
import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.mapper.EventoMapper;
import com.study.coffee.service.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping(value = "/filtrar")
    public ResponseEntity<List<EventoResponse>> list(
            @RequestParam(value = "idCategoriaEvento", required = false) CategoriaEvento idCategoriaEvento,
            @RequestParam(value = "dataInicio", required = false) @DateTimeFormat(pattern = "yyyy-mm-dd") Date dataInicio) {
        return ResponseEntity.ok(eventoService.listByIdCategoria(idCategoriaEvento, dataInicio).stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<EventoResponse> post(@Valid @RequestBody EventoCreateRequest model) {

        Evento evento = eventoService.create(mapper.fromDto(model));


        return ResponseEntity.ok(mapper.toDto(evento));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> put(@PathVariable Integer id, @RequestBody EventoCreateRequest model) {
        Evento evento = eventoService.updateEvento(id, mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(evento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(eventoService.deleteEvento(id)));
    }

}