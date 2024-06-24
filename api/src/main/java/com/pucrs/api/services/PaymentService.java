package com.pucrs.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.Payment;
import com.pucrs.api.repositories.PaymentRepository;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
}


public List<Payment> todos() {
    return paymentRepository.findAll();
}



public Payment acharPorId(Integer id) {
    return paymentRepository.findById(id).orElse(null);
}


public void registraPagamento(LocalDate data, Integer codApp, Float valorPago) {
    //
    throw new UnsupportedOperationException("Unimplemented method 'criaAssinatura'");
}
}
