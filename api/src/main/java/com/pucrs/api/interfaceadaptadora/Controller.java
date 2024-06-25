package com.pucrs.api.interfaceadaptadora;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.enums.SubscriptionStatusEnum;
import com.pucrs.api.models.App;
import com.pucrs.api.models.Client;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.repositories.AppRepository;
import com.pucrs.api.repositories.ClientRepository;
import com.pucrs.api.repositories.PaymentRepository;
import com.pucrs.api.repositories.SubscriptionRepository;
import com.pucrs.api.services.AppService;
import com.pucrs.api.services.ClientService;
import com.pucrs.api.services.PaymentService;
import com.pucrs.api.services.SubscriptionService;

import jakarta.websocket.server.PathParam;

import com.pucrs.api.repositories.ClientRepository;



@RestController
public class Controller {
    private ClientRepository clientRep;
    private AppRepository appRep;
    private PaymentRepository paymentRep;
    private SubscriptionRepository subscriptionRep;

    private ClientService clientService;    
    private AppService appService;    
    private PaymentService paymentService;
    private SubscriptionService subscriptionService;

    public Controller(ClientService cliServ, AppService appServ, PaymentService payServ, SubscriptionService subsServ) {
        this.clientService = cliServ;
        this.appService = appServ;            
        this.paymentService = payServ;        
        this.subscriptionService = subsServ;        
    }

    @GetMapping("servcad/clientes")
    @CrossOrigin(origins="*")
    public List<Client> getClients() {
        return clientService.todos();
    }

    @GetMapping("servcad/aplicativos")
    @CrossOrigin(origins="*")
    public List<App> getApplicativos() {
        return appService.todos();
    }

    @GetMapping("servcad/assinaturas/{tipo}")
    @CrossOrigin(origins="*")    
    public List<Subscription> getSubcriptionsByType(@PathVariable("tipo") String tipo) {
        return subscriptionService.assinaturasConformeTipo(tipo);
    }

    @GetMapping("servcad/asscli/{codClient}")
    @CrossOrigin(origins="*")    
    public List<Subscription> getSubscriptionByClient(@PathVariable("codClient") Integer codClient) {
        Client c = clientService.acharPorId(codClient);
        if (c == null) {
            return null;
        }
        return subscriptionService.todos().stream()
                                          .filter(cl -> cl.getClient().equals(c))
                                          .toList();
    }

    @GetMapping("servcad/assapp/{codApp}")
    @CrossOrigin(origins="*")    
    public List<Subscription> getSubscriptionByApp(@PathVariable("codApp") Integer codApp) {
        App app = appService.acharPorId(codApp);
        if (app == null) {
            return null;
        }
        return subscriptionService.todos().stream()
                                          .filter(ap -> ap.getApp().equals(app))
                                          .toList();
    }

    @GetMapping("assinvalida/{codSubscription}")
    @CrossOrigin(origins="*")    
    public boolean getSubscriptionIsActive(@PathVariable("codSubscription") Integer codSubscription) {
        Subscription sub = subscriptionService.acharPorId(codSubscription);
        if (sub == null) {
            return false;
        }
        return sub.getStatus() == SubscriptionStatusEnum.ACTIVE;
    }

    // @GetMapping("teste")
    // @CrossOrigin(origins="*")
    // public void cadastrar() {
    //     Client c = new Client(1, "nome", "email", "senha", null);
    //     clientRep.save(c);
    // }
}
