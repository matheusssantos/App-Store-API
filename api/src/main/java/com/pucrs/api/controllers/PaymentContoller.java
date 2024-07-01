package com.pucrs.api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.Payment;
import com.pucrs.api.models.Subscription;
import com.pucrs.api.services.PaymentService;
import com.pucrs.api.services.SubscriptionService;

@RestController
@RequestMapping("/payments")
public class PaymentContoller {

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private SubscriptionService subscriptionService;

  @GetMapping("")
  public ResponseEntity<List<Payment>> findAll() {
    List<Payment> payments = this.paymentService.todos();
    return ResponseEntity.ok(payments);
  }

  @PostMapping("/register")
  public String registerPayment(@RequestBody Map<String, Object> msgBody) {
    Float valorPago = Float.valueOf((String) msgBody.get("valorPago"));

    Subscription subs = this.subscriptionService.acharPorId((Integer) msgBody.get("codass"));
    String res = "";
    
    if (subs == null) {
      res = "{\"status\":\"ASS_INEXISTENTE\",\"data\":null,\"valor_estornado\":" + "\"" + valorPago.toString() + "\"}";
      return res;
    }
    
    String status = "";
    LocalDate dataPagamento = LocalDate.of(
      (Integer) msgBody.get("ano"),
      (Integer) msgBody.get("mes"),
      (Integer) msgBody.get("dia")
    );

    Payment pagamento = paymentService.registraPagamento(dataPagamento, subs, valorPago);
    Float estornado = 0.0f;

    if (pagamento == null) {
      status = "VALOR_INCORRETO";
      estornado = valorPago;
    } else {
      status = "PAGAMENTO_OK";
      subs = subscriptionService.atualiza(subs, pagamento);
    }
    
    res = "{\"status\":" + "\"" + status + "\"" + ",\"data\":" + "\"" + subs.getDuaDate().toString() + "\"" + ",\"valor_estornado\":" + "\"" + estornado.toString() + "\"}";
    return res;
  }
}
