package com.study.coffee.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.study.coffee.domain.dto.request.StatusEventoCreateRequest;
import com.study.coffee.domain.dto.response.StatusEventoResponse;
import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.domain.mapper.StatusEventoMapper;
import com.study.coffee.service.StatusEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/evento/status")
public class StatusEventoController {

    private final StatusEventoService statusEventoService;
    private final StatusEventoMapper mapper;

    @Autowired
    public StatusEventoController(StatusEventoService statusEventoService, StatusEventoMapper statusEventoMapper) {
        this.statusEventoService = statusEventoService;
        this.mapper = statusEventoMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StatusEventoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(statusEventoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<StatusEventoResponse>> list() {
        return ResponseEntity.ok(statusEventoService.list().stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/distinct")
    public ResponseEntity<List<String>> listDistinct() {
        return ResponseEntity.ok(statusEventoService.listDistinct());
    }

    @PostMapping
    public ResponseEntity<StatusEventoResponse> post(@Valid @RequestBody StatusEventoCreateRequest model) {

        StatusEvento statusEvento = statusEventoService.create(mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(statusEvento));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<StatusEventoResponse> put(@PathVariable Integer id, @RequestBody StatusEventoCreateRequest model) {
        //TODO: process PUT request
        StatusEvento statusEvento = statusEventoService.update(id, mapper.fromDto(model));
        
        return ResponseEntity.ok(mapper.toDto(statusEvento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StatusEventoResponse> delete(@PathVariable Integer id) {
        //TODO: process PUT request
        return ResponseEntity.ok(mapper.toDto(statusEventoService.deleteStatusEvento(id)));

    }
}