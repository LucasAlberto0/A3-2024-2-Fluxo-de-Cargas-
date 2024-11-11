package com.unimonte.a3.accesscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unimonte.a3.accesscontroller.config.EProfessionalConfig;
import com.unimonte.a3.accesscontroller.model.request.Depot;
import com.unimonte.a3.accesscontroller.model.request.Entrada;
import com.unimonte.a3.accesscontroller.model.request.Saida;
import com.unimonte.a3.accesscontroller.model.response.DefaultResponse;

import reactor.core.publisher.Mono;

@Service
public class AccessService {

    @Autowired
    EProfessionalConfig eProfessional;

    public DefaultResponse getToken(Depot depot) {
        return eProfessional.getWebClientSister()
            .post()
            .uri("/get")
            .bodyValue(depot)
            .exchangeToMono(response -> response.bodyToMono(String.class)
                .flatMap( bodyString -> {
                    try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = bodyString.replaceAll("^\"|\"$", "").replaceAll("\\\\", "");
                    DefaultResponse defaultResponse = objectMapper.readValue(jsonResponse, DefaultResponse.class);
                    return Mono.just(defaultResponse);
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                })
            )
            .block();
    }

    public DefaultResponse registrarEntrada(Entrada entrada) {
        return eProfessional.getWebClientWebsag()
            .post()
            .uri("/entrada")
            .bodyValue(entrada)
            .exchangeToMono(response -> response.bodyToMono(String.class)
                .flatMap( bodyString -> {
                    try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = bodyString.replaceAll("^\"|\"$", "").replaceAll("\\\\", "");
                    DefaultResponse defaultResponse = objectMapper.readValue(jsonResponse, DefaultResponse.class);
                    return Mono.just(defaultResponse);
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                })
            )
            .block();
    }

    public DefaultResponse registrarSaida(Saida saida) {
        return eProfessional.getWebClientWebsag()
            .post()
            .uri("/saida")
            .bodyValue(saida)
            .exchangeToMono(response -> response.bodyToMono(String.class)
                .flatMap( bodyString -> {
                    try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = bodyString.replaceAll("^\"|\"$", "").replaceAll("\\\\", "");
                    DefaultResponse defaultResponse = objectMapper.readValue(jsonResponse, DefaultResponse.class);
                    return Mono.just(defaultResponse);
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                })
            )
            .block();
    }
}
