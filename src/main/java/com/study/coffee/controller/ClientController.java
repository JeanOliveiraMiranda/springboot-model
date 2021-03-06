package com.study.coffee.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.study.coffee.domain.dto.request.ClientCreateRequest;
import com.study.coffee.domain.dto.response.ClientResponse;
import com.study.coffee.domain.entities.Client;
import com.study.coffee.domain.mapper.ClientMapper;
import com.study.coffee.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private final ClientService clientService;
	private final ClientMapper mapper;

	@Autowired
	public ClientController(ClientService clientService, ClientMapper clientMapper) {
		this.clientService = clientService;
		this.mapper = clientMapper;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientResponse> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(mapper.toDto(clientService.findById(id)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientResponse> deleteClient(@PathVariable Integer id) {
		return ResponseEntity.ok(mapper.toDto(clientService.delete(id)));
	}

	@GetMapping
	public ResponseEntity<List<ClientResponse>> list() {
		return ResponseEntity.ok(clientService.listClient().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<ClientResponse> post(@Valid @RequestBody ClientCreateRequest model) {

		Client client = clientService.createClient(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(client));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientResponse> put(@PathVariable Integer id, @Valid @RequestBody ClientCreateRequest model) {

		Client client = clientService.update(id, mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(client));
	}

}