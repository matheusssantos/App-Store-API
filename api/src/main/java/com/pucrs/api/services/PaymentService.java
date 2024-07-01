package com.pucrs.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.Subscription;
import com.pucrs.api.models.Plan;
import com.pucrs.api.enums.PaymentMethodEnum;
import com.pucrs.api.enums.SubscriptionStatusEnum;
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


public Payment registraPagamento(LocalDate dataPagamento, Subscription assinatura, Float valorPago) {
    Plan plano = assinatura.getPlan();
    Float porcentagemAPagar = 1.0f; //100%
    Float porcentagemDesconto = plano.getDiscountPercent();

    if (porcentagemDesconto > 1) {
        porcentagemAPagar -= (porcentagemDesconto / 100.0f);
    } else if (porcentagemDesconto > 0) {
        porcentagemAPagar -= porcentagemDesconto;
    }

    Float precoAssinatura = plano.getPrice() * porcentagemAPagar;

    if (!valorPago.equals(precoAssinatura)) {
        return null;
    }

    Payment pagamento = new Payment(
        new java.util.Random().nextInt(),
        valorPago,
        PaymentMethodEnum.CREDIT_CARD,
        plano.getName(),
        assinatura.getClient(),
        assinatura
    );
    pagamento.setCreatedDate(dataPagamento);
    return paymentRepository.save(pagamento);
}
}
