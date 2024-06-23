package com.pucrs.api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucrs.api.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  List<Payment> todos();

  Payment acharPorId(Integer id);
  
  void registraPagamento(LocalDate data, Integer codApp, Float valorPago);
}
