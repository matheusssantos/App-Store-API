package com.pucrs.api.models.repositories;

import java.time.LocalDate;
import java.util.List;

import com.pucrs.api.models.Payment;

public interface IPaymentRepository {
    List<Payment> todos();
    Payment acharPorId(Integer id);
    void registraPagamento(LocalDate data, Integer codApp, Float valorPago);
}
