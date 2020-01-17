package com.study.coffee.domain.mapper;

import com.study.coffee.domain.dto.request.ClientCreateRequest;
import com.study.coffee.domain.dto.response.ClientResponse;
import com.study.coffee.domain.entities.Client;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private final ModelMapper mapper;

    @Autowired
    public ClientMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ClientResponse toDto(Client input) {
        return mapper.map(input, ClientResponse.class);
    }

    public Client fromDto(ClientCreateRequest input) {
        return mapper.map(input, Client.class);
    }

}