package com.study.coffee.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.study.coffee.domain.dto.request.CategoriaEventoCreateRequest;
import com.study.coffee.domain.dto.response.CategoriaEventoResponse;
import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.mapper.CategoriaEventoMapper;
import com.study.coffee.service.CategoriaEventoService;

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
@RequestMapping("/evento/categoria")
public class CategoriaEventoController {

    private final CategoriaEventoService categoriaEventoService;
    private final CategoriaEventoMapper mapper;

    @Autowired
    public CategoriaEventoController(CategoriaEventoService categoriaEventoService, CategoriaEventoMapper categoriaEventoMapper) {
        this.categoriaEventoService = categoriaEventoService;
        this.mapper = categoriaEventoMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEventoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(categoriaEventoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaEventoResponse>> list() {
        return ResponseEntity.ok(categoriaEventoService.list().stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaEventoResponse> post(@Valid @RequestBody CategoriaEventoCreateRequest model) {

        CategoriaEvento categoriaEvento = categoriaEventoService.create(mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(categoriaEvento));
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<CategoriaEventoResponse> put(@PathVariable Integer id, @RequestBody CategoriaEventoCreateRequest model) {
        
        CategoriaEvento categoriaEvento = categoriaEventoService.update(id, mapper.fromDto(model));
        
        return ResponseEntity.ok(mapper.toDto(categoriaEvento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoriaEventoResponse> delete(@PathVariable Integer id){
        return ResponseEntity.ok(mapper.toDto(categoriaEventoService.deleteCategoriaEvento(id)));
    }

}