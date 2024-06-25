package com.pucrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.Payment;
import com.pucrs.api.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentContoller {

  @Autowired
  private PaymentService paymentService;

  @GetMapping("")
  public ResponseEntity<List<Payment>> findAll() {
    List<Payment> payments = this.paymentService.todos();
    return ResponseEntity.ok(payments);
  }
}
