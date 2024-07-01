package com.pucrs.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.App;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.repositories.AppRepository;

@Service
public class AppService {

  @Autowired
  private AppRepository appRepository;
  

  public AppService(AppRepository appRepository) {
    this.appRepository = appRepository;
}


public List<App> todos() {
    return appRepository.findAll();
}


public List<Subscription> listaAssinaturasApp(Integer id) {
    App aplicativo = appRepository.findById(id).orElse(null);
    if (aplicativo == null) {
        return null;
    }
    return aplicativo.getSubscriptions();
}


public App acharPorId(Integer id) {
    return appRepository.findById(id).orElse(null);
}


public App atualizaCusto(Integer idApp, Float custo) {
    App aplicativo = appRepository.findById(idApp).orElse(null);
    if (aplicativo == null) {
        return null;
    }
    aplicativo.setPrice(custo);
    return appRepository.save(aplicativo);
}

public App save(App app) {
    return appRepository.save(app);
}

}
