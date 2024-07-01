package com.pucrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.Client;
import com.pucrs.api.services.ClientService;


@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping("")
  public List<Client> findAll() {
    return this.clientService.todos();
  }
  
}
