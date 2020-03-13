package com.everis.banca.cliente.service;

import com.everis.banca.cliente.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICrudServiceForClient<M,N>{
    Mono<M> createClient(M m);
    Mono<M> updateClient(M m);
    Flux<M> findAllClient();
    Mono<M> findClientById(N n);
    Mono<Void> deleteClientById(N n);
}
