package com.everis.banca.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document
@Getter
@Setter
@AllArgsConstructor
public class TypeClient {
    @Id
    private String idTypeClient;
    @NotNull
    @NotEmpty
    private String codeTypeClient;
    @NotEmpty
    @NotNull
    private String nameTypeClient;
}
