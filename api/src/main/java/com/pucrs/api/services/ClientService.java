package com.pucrs.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.Client;
import com.pucrs.api.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> todos() {
        return clientRepository.findAll();
    }

    public Client acharPorId(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public boolean create(Client c) {
        try {
            this.clientRepository.save(c);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public boolean verifyLogin(String email, String password) {
        try {
            Client client = this.clientRepository.findByEmail(email);
            if (client.equals(null)) {
                return false;
            }

            if (!client.getPassword().equals(password)) {
                return false;
            }

            return true;
        } catch (Error error) {
            return false;
        }

    }
}
