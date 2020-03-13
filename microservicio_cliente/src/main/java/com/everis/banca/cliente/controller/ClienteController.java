package com.everis.banca.cliente.controller;

import com.everis.banca.cliente.model.Cliente;
import com.everis.banca.cliente.service.IClienteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/client")
public class ClienteController {
    private final IClienteService iClienteService;

    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }
    @PostMapping("/createClient")
    public Mono<Cliente> createClient(@RequestBody Cliente cliente){
        return iClienteService.createClient(cliente);
    }
    @PutMapping("/updateClient")
    public Mono<Cliente>updateClient(@RequestBody Cliente cliente){
        return  iClienteService.updateClient(cliente);
    }
    @GetMapping("/findAllClient")
    public Flux<Cliente> findAllClient(){
        return iClienteService.findAllClient();
    }
    @GetMapping("/findClientById/{id}")
    public Mono<Cliente>findClientById(@PathVariable String id ){
        return iClienteService.findClientById(id);
    }
    @DeleteMapping("/deleteClientById/{id}")
    public Mono<Void> deleteClientById(@PathVariable String id){
        return iClienteService.deleteClientById(id);
    }
}
