package com.everis.banca.cliente.service.impl;

import com.everis.banca.cliente.model.Client;
import com.everis.banca.cliente.repository.IClientRepository;
import com.everis.banca.cliente.service.IClientService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clienteRepository;

    public ClientServiceImpl(IClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Mono<Client> create(Client client) {
        return clienteRepository.save(client);
    }

    @Override
    public Mono<Client> update(Client client) {
        return clienteRepository.save(client);
    }

    @Override
    public Flux<Client> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Mono<Client> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteRepository.deleteById(id);
    }


}
