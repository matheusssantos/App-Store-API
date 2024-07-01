package com.pucrs.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.App;
import com.pucrs.api.services.AppService;

@RestController
@RequestMapping("/apps")
public class AppController {
  
  @Autowired
  private AppService appService;

  @GetMapping("")
  public List<App> getApplicativos() {
    return this.appService.todos();
  }

  @PostMapping("/id/{idAplicativo}/update-custo")
  public App updateCost(@PathVariable(value = "idAplicativo") Integer idAplicativo, @RequestBody Map<String, Object> msgRequest) {
    App app = this.appService.acharPorId(idAplicativo);

    if (app == null) {
      throw new IllegalArgumentException("Aplicativo não encontrado");
    }
    
    Float novoCusto = Float.valueOf((String) msgRequest.get("custo"));
    this.appService.atualizaCusto(idAplicativo, novoCusto);

    App updatedApp = this.appService.save(app);
    return updatedApp;
  }
}
