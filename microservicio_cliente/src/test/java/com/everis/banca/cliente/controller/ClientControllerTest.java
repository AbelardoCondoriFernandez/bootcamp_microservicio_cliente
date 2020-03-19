package com.everis.banca.cliente.controller;

import com.everis.banca.cliente.model.Client;
import com.everis.banca.cliente.repository.IClientRepository;
import com.everis.banca.cliente.service.IClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ClientController.class)
@Import(IClientService.class)
public class ClientControllerTest {

    @MockBean
    protected IClientRepository iClientRepository;
    @MockBean
    protected IClientService iClientService;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void createClientTest(){
        Client client =new Client();
        client.setIdClient("1234");
        client.setNameClient("Lancer");
        client.setLastNameClient("Night Void");
        client.setDocumentClient("7654321");
        client.setPhoneClient("987654321");
        Mockito.when(iClientService.create(client)).thenReturn(Mono.just(client));

        webTestClient.post()
                .uri("/client/createClient")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(client))
                .exchange()
                .expectStatus().isOk();
    }
    @Test
    public void updateClientTest(){

        Client client =new Client();
        client.setIdClient("1234");
        client.setNameClient("Lancer");
        client.setLastNameClient("Night Void");
        client.setDocumentClient("7654321");
        client.setPhoneClient("987654321");
        Mockito.when(iClientService.update(client)).thenReturn(Mono.just(client));

        webTestClient.put()
                .uri("/client/updateClient")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(client))
                .exchange();
    }

}
