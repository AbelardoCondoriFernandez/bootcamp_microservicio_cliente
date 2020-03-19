package com.everis.banca.cliente.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Document
public class Client {
    @Id
    private String idClient;
    @NotNull
    @NotEmpty
    private String codeClient;
    @NotNull
    private String nameClient;
    @NotNull
    private String lastNameClient;
    @NotEmpty
    private String documentClient;
    @NotNull
    private String phoneClient;
    @Valid
    @DBRef
    private TypeClient typeClient;
}
