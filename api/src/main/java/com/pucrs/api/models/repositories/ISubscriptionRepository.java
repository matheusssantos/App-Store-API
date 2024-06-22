package com.pucrs.api.models.repositories;

import java.util.List;

import com.pucrs.api.models.Subscription;
import com.pucrs.api.models.Client;
import com.pucrs.api.models.App;

public interface ISubscriptionRepository {
    List<Subscription> todos();
    Subscription acharPorId(Integer id);
    List<Subscription> assinaturasConformeTipo(String tipo);
    Subscription criaAssinatura(Client cli, App app);
}
