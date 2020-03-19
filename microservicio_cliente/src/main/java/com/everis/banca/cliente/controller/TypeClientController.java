package com.everis.banca.cliente.controller;

import com.everis.banca.cliente.model.TypeClient;
import com.everis.banca.cliente.service.ITypeClientService;
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
@RequestMapping("/typeClient")
public class TypeClientController {
    private final ITypeClientService typeClientService;

    public TypeClientController(ITypeClientService typeClientService) {
        this.typeClientService = typeClientService;
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<TypeClient>> createClient(@Valid @RequestBody TypeClient typeClient, final ServerHttpRequest request) {
        return typeClientService.create(typeClient).map(create -> ResponseEntity
                .created(URI.create(request.getURI().toString().concat("/").concat(create.getIdTypeClient())))
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(create));
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<TypeClient>> updateClient(@Valid @RequestBody TypeClient typeClient) {
        return typeClientService.update(typeClient)
                .map(cli -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(cli))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Mono<ResponseEntity<Flux<TypeClient>>> findAllClient() {
        Flux<TypeClient> client = typeClientService.findAll();
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(client));
    }

    @GetMapping("/findById/{id}")
    public Mono<ResponseEntity<TypeClient>> findClientById(@PathVariable("id") String id) {
        return typeClientService.findById(id).map(typeClient -> ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(typeClient))
                .defaultIfEmpty(ResponseEntity.notFound()
                        .build());
    }

    @DeleteMapping("/deleteById/{id}")
    public Mono<ResponseEntity<Void>> deleteClientById(@PathVariable("id") String id) {
        return typeClientService.findById(id)
                .flatMap(typeClient -> {
                    return typeClientService.deleteById(typeClient.getIdTypeClient())
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
