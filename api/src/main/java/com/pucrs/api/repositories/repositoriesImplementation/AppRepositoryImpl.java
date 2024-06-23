package com.pucrs.api.repositories.repositoriesImplementation;

import java.util.List;

import com.pucrs.api.models.App;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.models.repositories.IAppRepository;
import com.pucrs.api.repositories.AppRepository;

public class AppRepositoryImpl implements IAppRepository {
    private AppRepository appRep;

    public AppRepositoryImpl(AppRepository appRep) {
        this.appRep = appRep;
    }

    @Override
    public List<App> todos() {
        return appRep.findAll();
    }

    @Override
    public List<Subscription> listaAssinaturasApp(Integer id) {
        App aplicativo = appRep.findById(id).orElse(null);
        if (aplicativo == null) {
            return null;
        }
        return aplicativo.getSubscriptions();
    }

    @Override
    public App acharPorId(Integer id) {
        return appRep.findById(id).orElse(null);
    }

    @Override
    public App atualizaCusto(Integer idApp, Float custo) {
        App aplicativo = appRep.findById(idApp).orElse(null);
        if (aplicativo == null) {
            return null;
        }
        aplicativo.setPrice(custo);
        return appRep.save(aplicativo);
    }

}
