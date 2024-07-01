package com.pucrs.api.controllers;

import java.util.List;

import org.antlr.v4.runtime.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.Client;
import com.pucrs.api.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping("")
  public ResponseEntity<List<Client>> findAll() {
    List<Client> clients = this.clientService.todos();
    return ResponseEntity.ok(clients);
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Client entity) {
    // this.clientService.cre(entity);
    // final String token = "TESTEDETOKEN123";

    return ResponseEntity.ok("token");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody Client entity) {
    // final boolean success = this.clientService.verifyLogin(entity);
    // if (success) {
    //   final String token = "TESTEDETOKEN123";
    //   return ResponseEntity.ok(token);
    // }
    
    return ResponseEntity.ok("");
  }
  
}
