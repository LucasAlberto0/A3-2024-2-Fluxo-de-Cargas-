package com.unimonte.a3.accesscontroller.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimonte.a3.accesscontroller.model.request.Depot;
import com.unimonte.a3.accesscontroller.model.request.Entrada;
import com.unimonte.a3.accesscontroller.model.request.Saida;
import com.unimonte.a3.accesscontroller.model.response.DefaultResponse;
import com.unimonte.a3.accesscontroller.service.AccessService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/accesscontroller")
@CrossOrigin("*")
public class AccessController {
    
    @Autowired
    AccessService service;

    @PostMapping("/get-token")
    public ResponseEntity<Map<String, String>> getToken(@RequestBody Depot entity) {
        DefaultResponse response = service.getToken(entity);
        
        if (response.isSuccess()) {
            Map<String, String> map = Map.of("token", response.getChave().getChave());
            return ResponseEntity.ok(map);
        } else {
            Map<String, String> map = Map.of("error", response.getError());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @PostMapping("/register-entry")
    public ResponseEntity<DefaultResponse> registrarEntrada(@RequestBody Entrada entity) {
        DefaultResponse response = service.registrarEntrada(entity);
        
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PostMapping("/register-exit")
    public ResponseEntity<DefaultResponse> registrarSaida(@RequestBody Saida entity) {
        DefaultResponse response = service.registrarSaida(entity);
        
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
