package com.everis.banca.cliente.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICrud<C,S> {
    Mono<C> create(C c);
    Mono<C> update(C c);
    Flux<C> findAll();
    Mono<C> findById(S s);
    Mono<Void> deleteById(S s);
}
