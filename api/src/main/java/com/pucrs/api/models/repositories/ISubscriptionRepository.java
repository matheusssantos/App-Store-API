package com.pucrs.api.models.repositories;

import java.util.List;

import com.pucrs.api.models.Subscription;

public interface ISubscriptionRepository {
    List<Subscription> todos();
    Subscription acharPorId(Integer id);
    List<Subscription> assinaturasConformeTipo(String tipo);
    Subscription criaAssinatura(Integer codCliente, Integer codApp);
}
