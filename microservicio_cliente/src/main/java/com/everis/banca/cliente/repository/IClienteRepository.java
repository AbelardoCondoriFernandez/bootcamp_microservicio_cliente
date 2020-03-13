package com.everis.banca.cliente.repository;

import com.everis.banca.cliente.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IClienteRepository extends ReactiveMongoRepository <Cliente,String> {
}
