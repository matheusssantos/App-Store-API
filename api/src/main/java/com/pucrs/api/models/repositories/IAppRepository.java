package com.pucrs.api.models.repositories;

import java.util.List;

import com.pucrs.api.models.App;
import com.pucrs.api.models.Subscription;

public interface IAppRepository {
    List<App> todos();
    App acharPorId(Integer id);
    App atualizaCusto(Integer idApp, Float custo);
    List<Subscription> listaAssinaturasApp(Integer id);
}
