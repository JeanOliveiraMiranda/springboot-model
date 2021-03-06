package com.study.coffee.service;

import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.Client;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client model) {
        return clientRepository.save(model);
    }

    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }

    public Client delete(Integer id) {

        Optional<Client> client = clientRepository.findById(id);

        // erro 500 quando não encontra o cliente

        clientRepository.deleteById(id);

        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }

    public Client update(Integer id, Client model) {
        Optional<Client> client = clientRepository.findById(id);

        model.setId(id);

        clientRepository.save(model);

        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));

    }

}