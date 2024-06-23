package com.pucrs.api.repositories.repositoriesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.Client;
import com.pucrs.api.models.repositories.IClientRepository;
import com.pucrs.api.repositories.ClientRepository;

public class ClientRepositoryImpl implements IClientRepository {
    private ClientRepository clientRep;

    public ClientRepositoryImpl(ClientRepository clientRep){
        this.clientRep = clientRep;


    }

    @Override
    public List<Client> todos() {
        return clientRep.findAll();
    }
   
   
    @Override
    public Client acharPorId(Integer id) {
        return clientRep.findById(id).orElse(null);
    }


    @Override
    public void cadastrar(Client c) {
        clientRep.save(c);
    }




}