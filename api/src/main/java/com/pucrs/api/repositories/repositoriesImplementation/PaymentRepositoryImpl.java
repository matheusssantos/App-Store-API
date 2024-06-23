package com.pucrs.api.repositories.repositoriesImplementation;

import java.time.LocalDate;
import java.util.List;

import com.pucrs.api.models.Payment;
import com.pucrs.api.models.repositories.IPaymentRepository;
import com.pucrs.api.repositories.PaymentRepository;

public class PaymentRepositoryImpl implements IPaymentRepository {
    private PaymentRepository paymentRep;

    public PaymentRepositoryImpl(PaymentRepository paymentRep) {
        this.paymentRep = paymentRep;
    }

    @Override
    public List<Payment> todos() {
        return paymentRep.findAll();
    }
   
   
    @Override
    public Payment acharPorId(Integer id) {
        return paymentRep.findById(id).orElse(null);
    }

    @Override
    public void registraPagamento(LocalDate data, Integer codApp, Float valorPago) {
        //
        throw new UnsupportedOperationException("Unimplemented method 'criaAssinatura'");
    }
}

