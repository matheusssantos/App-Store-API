package com.pucrs.api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.enums.SubscriptionStatusEnum;
import com.pucrs.api.models.App;
import com.pucrs.api.models.Client;
import com.pucrs.api.models.Plan;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.models.User;
import com.pucrs.api.services.AppService;
import com.pucrs.api.services.ClientService;
import com.pucrs.api.services.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

  @Autowired
  private SubscriptionService subscriptionService;
  
  @Autowired
  private AppService appService;
  
  @Autowired
  private ClientService clientService;

  @GetMapping("")
  public ResponseEntity<List<Subscription>> findAll() {
    List<Subscription> subscriptions = this.subscriptionService.todos();
    return ResponseEntity.ok(subscriptions);
  }

  @GetMapping("/app/{codApp}")
  public List<Subscription> getSubscriptionByApp(@PathVariable("codApp") Integer codApp) {
    App app = this.appService.acharPorId(codApp);
    if (app == null) {
      return null;
    }
    
    return this.subscriptionService.todos()
      .stream()
      .filter(ap -> ap.getApp().equals(app))
      .toList();
  }

  @GetMapping("/{codSubscription}/is-valid")
  public boolean getSubscriptionIsActive(@PathVariable("codSubscription") Integer codSubscription) {
    Subscription sub = this.subscriptionService.acharPorId(codSubscription);
    if (sub == null) {
      return false;
    }

    return sub.getStatus() == SubscriptionStatusEnum.ACTIVE;
  }

  @PostMapping("/create")
  public Subscription createSubscription(@RequestBody Map<String, Object> request) {
    Integer codClient = (Integer) request.get("codClient");
    Integer codApp = (Integer) request.get("codApp");

    Client client = this.clientService.acharPorId(codClient);
    if (client == null) {
      throw new IllegalArgumentException("Cliente não encontrado");
    }

    App app = this.appService.acharPorId(codApp);       
    if (app == null) {
      throw new IllegalArgumentException("Aplicativo não encontrado");
    }
    
    User user = app.getUser();
    List<Plan> plansList = user.getPlans();
    Plan p = plansList.get(0);
    Subscription subscription = new Subscription(null, LocalDate.now().plusMonths(1), client, app, p, null);
    subscription.setStartDate(LocalDate.now());
    subscription.setStatus(SubscriptionStatusEnum.ACTIVE);

    return this.subscriptionService.save(subscription);
  }

  @GetMapping("/find-by-type/{tipo}")
  public List<Subscription> getSubcriptionsByType(@PathVariable("tipo") String tipo) {
    return this.subscriptionService.assinaturasConformeTipo(tipo);
  }

  @GetMapping("/find-by-client/{codClient}")
  public List<Subscription> getSubscriptionByClient(@PathVariable("codClient") Integer codClient) {
    Client c = clientService.acharPorId(codClient);
    if (c == null) {
      return null;
    }

    return this.subscriptionService.todos()
      .stream()
      .filter(cl -> cl.getClient().equals(c))
      .toList();
  }
}
