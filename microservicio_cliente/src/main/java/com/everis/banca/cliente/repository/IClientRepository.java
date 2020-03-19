package com.everis.banca.cliente.repository;

import com.everis.banca.cliente.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IClientRepository extends ReactiveMongoRepository <Client,String> {
}
