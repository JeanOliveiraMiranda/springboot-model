package com.study.coffee.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.study.coffee.domain.dto.request.ConfirmacaoCreateRequest;
import com.study.coffee.domain.dto.request.InscricaoCreateRequest;
import com.study.coffee.domain.dto.request.ParticipacaoCreateRequest;
import com.study.coffee.domain.dto.response.ParticipacaoResponse;
import com.study.coffee.domain.entities.Participacao;
import com.study.coffee.domain.mapper.ParticipacaoMapper;
import com.study.coffee.service.ParticipacaoService;

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
@RequestMapping("/participacao")
public class ParticipacaoController {

    private final ParticipacaoService participacaoService;

    private final ParticipacaoMapper mapper;

    @Autowired
    public ParticipacaoController(ParticipacaoService participacaoService, ParticipacaoMapper participacaoMapper) {
        this.participacaoService = participacaoService;
        this.mapper = participacaoMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(participacaoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ParticipacaoResponse>> list() {
        return ResponseEntity.ok(participacaoService.list().stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ParticipacaoResponse> post(@Valid @RequestBody ParticipacaoCreateRequest model) {

        Participacao participacao = participacaoService.create(mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(participacao));
    }

    @PostMapping(value = "/inscricao")
    public ResponseEntity<ParticipacaoResponse> inscrever(@Valid @RequestBody InscricaoCreateRequest model) {

        Participacao participacao = participacaoService.inscrever(mapper.fromDtoInsc(model));

        return ResponseEntity.ok(mapper.toDto(participacao));
    }

    @PutMapping(value = "/inscricao/confirmacao/{id}")
    public ResponseEntity<ParticipacaoResponse> confirmacao(@PathVariable Integer id,
            @RequestBody ConfirmacaoCreateRequest model) {

        Participacao participacao = participacaoService.confirmacaoEvento(id, mapper.fromDtoConfirm(model));

        return ResponseEntity.ok(mapper.toDto(participacao));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> put(@PathVariable Integer id,
            @RequestBody ParticipacaoCreateRequest model) {
        Participacao participacao = participacaoService.update(id, mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(participacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> delete(@PathVariable Integer id) {

        return ResponseEntity.ok(mapper.toDto(participacaoService.deleteParticipacao(id)));

    }
}