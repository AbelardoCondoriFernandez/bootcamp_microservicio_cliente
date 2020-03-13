package com.everis.banca.cliente.service.impl;

import com.everis.banca.cliente.model.Cliente;
import com.everis.banca.cliente.repository.IClienteRepository;
import com.everis.banca.cliente.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements IClienteService {

private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Mono<Cliente> createClient(Cliente m) {
        return clienteRepository.save(m);
    }

    @Override
    public Mono<Cliente> updateClient(Cliente m) {
        return clienteRepository.save(m);
    }

    @Override
    public Flux<Cliente> findAllClient() {
        return clienteRepository.findAll();
    }

    @Override
    public Mono<Cliente> findClientById(String n) {
        return clienteRepository.findById(n);
    }

    @Override
    public Mono<Void> deleteClientById(String n) {
        return clienteRepository.deleteById(n);
    }


}
