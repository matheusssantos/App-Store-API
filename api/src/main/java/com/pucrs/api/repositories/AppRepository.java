package com.pucrs.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucrs.api.models.App;
import com.pucrs.api.models.Subscription;

@Repository
public interface AppRepository extends JpaRepository<App, Integer> {

  // List<App> todos();

  // App acharPorId(Integer id);
  
  // App atualizaCusto(Integer idApp, Float custo);
  
  // List<Subscription> listaAssinaturasApp(Integer id);
}
