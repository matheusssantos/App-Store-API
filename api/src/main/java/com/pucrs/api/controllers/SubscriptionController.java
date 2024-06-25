package com.pucrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.Subscription;
import com.pucrs.api.services.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

  @Autowired
  private SubscriptionService subscriptionService;

  @GetMapping("")
  public ResponseEntity<List<Subscription>> findAll() {
    List<Subscription> subscriptions = this.subscriptionService.todos();
    return ResponseEntity.ok(subscriptions);
  }
}
