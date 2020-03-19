package com.everis.banca.cliente.service.impl;

import com.everis.banca.cliente.model.TypeClient;
import com.everis.banca.cliente.repository.ITypeClientRepository;
import com.everis.banca.cliente.service.ITypeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeClientServiceImpl implements ITypeClientService{

    private final ITypeClientRepository typeClientRepository;

    public TypeClientServiceImpl(ITypeClientRepository typeClientRepository) {
        this.typeClientRepository = typeClientRepository;
    }

    @Override
    public Mono<TypeClient> create(TypeClient typeClient) {
        return typeClientRepository.save(typeClient);
    }

    @Override
    public Mono<TypeClient> update(TypeClient typeClient) {
        return typeClientRepository.save(typeClient);
    }

    @Override
    public Flux<TypeClient> findAll() {
        return typeClientRepository.findAll();
    }

    @Override
    public Mono<TypeClient> findById(String idTypeClient) {
        return typeClientRepository.findById(idTypeClient);
    }

    @Override
    public Mono<Void> deleteById(String idTypeClient) {
        return typeClientRepository.deleteById(idTypeClient);
    }
}
