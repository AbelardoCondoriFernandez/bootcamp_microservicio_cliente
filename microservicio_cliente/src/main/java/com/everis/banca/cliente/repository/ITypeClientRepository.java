package com.everis.banca.cliente.repository;

import com.everis.banca.cliente.model.TypeClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ITypeClientRepository extends ReactiveMongoRepository<TypeClient,String> {
}
