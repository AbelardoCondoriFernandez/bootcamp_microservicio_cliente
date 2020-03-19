package com.everis.banca.cliente.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {
    @Test
    public void clienteTest(){
        Client client =new Client();
        client.setIdClient("123");
        client.setNameClient("Juancho");
        client.setLastNameClient("Juarez de Mexico");
        client.setDocumentClient("7654321");
        client.setPhoneClient("987654321");
        Assertions.assertEquals("123", client.getIdClient());
        Assertions.assertEquals("Juancho", client.getNameClient());
        Assertions.assertEquals("Juarez de Mexico", client.getLastNameClient());
        Assertions.assertEquals("7654321", client.getDocumentClient());
        Assertions.assertEquals("987654321", client.getPhoneClient());
    }
}
