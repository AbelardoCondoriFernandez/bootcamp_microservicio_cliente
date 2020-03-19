package com.everis.banca.cliente.controller;

import com.everis.banca.cliente.model.Client;
import com.everis.banca.cliente.service.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private final IClientService iClientService;

    public ClientController(IClientService iClientService) {
        this.iClientService = iClientService;
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<Client>> createClient(@Valid @RequestBody Client client, final ServerHttpRequest request) {
        return iClientService.create(client).map(create -> ResponseEntity
                .created(URI.create(request.getURI().toString().concat("/").concat(create.getIdClient())))
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(create));
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<Client>> updateClient(@Valid @RequestBody Client client) {
        return iClientService.update(client)
                .map(cli -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(cli))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Mono<ResponseEntity<Flux<Client>>> findAllClient() {
        Flux<Client> cliente = iClientService.findAll();
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(cliente));
    }

    @GetMapping("/findById/{id}")
    public Mono<ResponseEntity<Client>> findClientById(@PathVariable("id") String id) {
        return iClientService.findById(id).map(cliente -> ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(cliente))
                .defaultIfEmpty(ResponseEntity.notFound()
                        .build());
    }

    @DeleteMapping("/deleteById/{id}")
    public Mono<ResponseEntity<Void>> deleteClientById(@PathVariable("id") String id) {
        return iClientService.findById(id)
                .flatMap(cliente -> {
                    return iClientService.deleteById(cliente.getIdClient())
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
