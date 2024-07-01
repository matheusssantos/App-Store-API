package com.pucrs.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.dtos.ClientDTO;
import com.pucrs.api.models.Client;
import com.pucrs.api.services.ClientService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping("")
  public List<Client> findAll() {
    return this.clientService.todos();
  }

  @PostMapping("/register")
  public Client register(@RequestBody ClientDTO body) {
    final Client client = new Client(null,  body.name, body.email, body.password, null);

    this.clientService.create(client);

    return client;
  }
  
}
