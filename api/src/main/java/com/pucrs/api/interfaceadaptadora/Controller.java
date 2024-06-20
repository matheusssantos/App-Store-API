package com.pucrs.api.interfaceadaptadora;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.App;
import com.pucrs.api.models.Client;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.repositories.AppRepository;
import com.pucrs.api.repositories.ClientRepository;
import com.pucrs.api.repositories.PaymentRepository;
import com.pucrs.api.repositories.SubscriptionRepository;
import com.pucrs.api.repositories.ClientRepository;



@RestController
public class Controller {
    private ClientRepository clientRep;
    private AppRepository appRep;
    private PaymentRepository paymentRep;
    private SubscriptionRepository subscriptionRep;


    public Controller(ClientRepository rep) {
        this.clientRep = rep;
    }

    @GetMapping("servcad/clientes")
    @CrossOrigin(origins="*")
    public List<Client> getClients() {
        return clientRep.findAll();
    }

    @GetMapping("servcad/aplicativos")
    @CrossOrigin(origins="*")
    public List<App> getApplicativos() {
        return appRep.findAll();
    }

    @GetMapping("servcad/assinaturas/{tipo}")
    @CrossOrigin(origins="*")    
    public List<Subscription> getClientSubcriptions() {
        return null;
    }

    @GetMapping("teste")
    @CrossOrigin(origins="*")
    public void cadastrar() {
        Client c = new Client(1, "nome", "email", "senha", null);
        clientRep.save(c);
    }
}
