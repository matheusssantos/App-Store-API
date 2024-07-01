package com.pucrs.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucrs.api.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

  // List<Client> todos();
  
  // void cadastrar(Client c);
  
  // Client acharPorId(Integer id);

  Client findByEmail(String email);
}
