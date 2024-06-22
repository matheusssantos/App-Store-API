package com.pucrs.api.models.repositories;

import java.util.List;

import com.pucrs.api.models.Client;

public interface IClientRepository {
    List<Client> todos();
    void cadastrar(Client c);
    Client acharPorId(Integer id);
}
