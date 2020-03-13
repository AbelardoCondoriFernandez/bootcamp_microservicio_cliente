package com.everis.banca.cliente.controller;

import com.everis.banca.cliente.model.Cliente;
import com.everis.banca.cliente.repository.IClienteRepository;
import com.everis.banca.cliente.service.IClienteService;
import com.everis.banca.cliente.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ClienteController.class)
@Import(IClienteService.class)
public class ClienteControllerTest {

    @MockBean
    protected IClienteRepository iClienteRepository;
    @MockBean
    protected IClienteService iClienteService;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void createClientTest(){
        Cliente cliente=new Cliente();
        cliente.setId("1234");
        cliente.setNameClient("Lancer");
        cliente.setLastNameClient("Night Void");
        cliente.setDocumentClient("7654321");
        cliente.setPhoneClient("987654321");
        Mockito.when(iClienteService.createClient(cliente)).thenReturn(Mono.just(cliente));

        webTestClient.post()
                .uri("/client/createClient")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(cliente))
                .exchange()
                .expectStatus().isOk();
    }
    @Test
    public void updateClientTest(){

        Cliente cliente=new Cliente();
        cliente.setId("1234");
        cliente.setNameClient("Lancer");
        cliente.setLastNameClient("Night Void");
        cliente.setDocumentClient("7654321");
        cliente.setPhoneClient("987654321");
        Mockito.when(iClienteService.updateClient(cliente)).thenReturn(Mono.just(cliente));

        webTestClient.put()
                .uri("/client/updateClient")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(cliente))
                .exchange();
    }

}
