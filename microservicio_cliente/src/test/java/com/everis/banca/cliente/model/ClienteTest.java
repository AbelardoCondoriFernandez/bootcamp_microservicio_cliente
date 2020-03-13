package com.everis.banca.cliente.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {
    @Test
    public void clienteTest(){
        Cliente cliente=new Cliente();
        cliente.setId("123");
        cliente.setNameClient("Juancho");
        cliente.setLastNameClient("Juarez de Mexico");
        cliente.setDocumentClient("7654321");
        cliente.setPhoneClient("987654321");
        Assertions.assertEquals("123",cliente.getId());
        Assertions.assertEquals("Juancho",cliente.getNameClient());
        Assertions.assertEquals("Juarez de Mexico",cliente.getLastNameClient());
        Assertions.assertEquals("7654321",cliente.getDocumentClient());
        Assertions.assertEquals("987654321",cliente.getPhoneClient());
    }
}
