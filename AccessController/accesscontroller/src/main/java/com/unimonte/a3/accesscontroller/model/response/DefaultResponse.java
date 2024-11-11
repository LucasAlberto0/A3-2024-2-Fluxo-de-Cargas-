package com.unimonte.a3.accesscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DefaultResponse {

    @JsonProperty("SUCCESS")
    private boolean success;

    @JsonProperty("ERROR")
    private String error;

    @JsonProperty("OBJECT")
    private Token chave;

    public DefaultResponse(String success, String error, Token chave) {
        this.success = Boolean.parseBoolean(success);
        this.error = error;
        this.chave = chave;
    }
}
