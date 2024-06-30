package com.pucrs.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.enums.SubscriptionStatusEnum;
import com.pucrs.api.models.App;
import com.pucrs.api.models.Client;
import com.pucrs.api.models.Payment;
import com.pucrs.api.models.Plan;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.repositories.SubscriptionRepository;

@Service
public class SubscriptionService {

  @Autowired
  private SubscriptionRepository subscriptionRepository;

  public SubscriptionService(SubscriptionRepository subscriptionRepository) {
    this.subscriptionRepository = subscriptionRepository;    
}

public List<Subscription> todos() {
    return subscriptionRepository.findAll();
}

public Subscription acharPorId(Integer id) {
    return subscriptionRepository.findById(id).orElse(null);
}

public Subscription atualiza(Subscription subs, Payment pagamento) {
    Plan plano = subs.getPlan();
    LocalDate dueDate = subs.getDuaDate();
    LocalDate dataPagamento = pagamento.getCreatedDate();

    if (dataPagamento.compareTo(dueDate) < 0) {
        subs.setDuaDate(dueDate.plusDays(plano.getAvailableDays()));
    } else {
        subs.setDuaDate(dataPagamento.plusDays(plano.getAvailableDays()));
    }

    subs.setPayment(pagamento);
    subs.setStatus(SubscriptionStatusEnum.ACTIVE);
    return subscriptionRepository.save(subs);
}


public Subscription criaAssinatura(Client cli, App app) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'criaAssinatura'");
}


public List<Subscription> assinaturasConformeTipo(String tipo) {
    SubscriptionStatusEnum status = null;

    switch (tipo.toUpperCase()) {
        case "TODAS":
            return this.todos();
        case "ATIVAS": 
            status = SubscriptionStatusEnum.ACTIVE;
            break;
        case "CANCELADAS":
            status = SubscriptionStatusEnum.CANCELED;
            break;
        default:
            return null;
    }

    final SubscriptionStatusEnum stat = status;
    return subscriptionRepository.findAll().stream()
                           .filter(sub -> sub.getStatus() == stat)
                           .toList();
}

}
