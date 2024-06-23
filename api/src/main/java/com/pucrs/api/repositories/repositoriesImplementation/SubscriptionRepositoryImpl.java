package com.pucrs.api.repositories.repositoriesImplementation;

import java.util.List;

import com.pucrs.api.enums.SubscriptionStatusEnum;
import com.pucrs.api.models.App;
import com.pucrs.api.models.Client;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.models.repositories.ISubscriptionRepository;
import com.pucrs.api.repositories.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements ISubscriptionRepository {
    private SubscriptionRepository subRep;

    public SubscriptionRepositoryImpl(SubscriptionRepository subRep) {
        this.subRep = subRep;    
    }

    @Override
    public List<Subscription> todos() {
        return subRep.findAll();
    }

    @Override
    public Subscription acharPorId(Integer id) {
        return subRep.findById(id).orElse(null);
    }

    @Override
    public Subscription criaAssinatura(Client cli, App app) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criaAssinatura'");
    }

    @Override
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
        return subRep.findAll().stream()
                               .filter(sub -> sub.getStatus() == stat)
                               .toList();
    }
}
