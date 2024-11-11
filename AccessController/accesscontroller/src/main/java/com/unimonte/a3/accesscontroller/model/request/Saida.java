package com.unimonte.a3.accesscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Saida {

    @JsonProperty("CHAVE")
    private String chave;
    @JsonProperty("TIPO")
    private String tipo;
    @JsonProperty("OS")
    private String os;
    @JsonProperty("ARMADOR")
    private String armador;
    @JsonProperty("DATA")
    private String data;
    @JsonProperty("CONTAINER")
    private String container;
    @JsonProperty("DEPOT")
    private String depot;
    @JsonProperty("DEPOSITO")
    private String deposito;
    @JsonProperty("TERMINAL")
    private String terminal;
}
