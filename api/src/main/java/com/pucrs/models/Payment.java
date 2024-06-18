package com.pucrs.models;

import java.time.LocalDate;

import com.pucrs.enums.PaymentMethodEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Float value;
  
  @Column(nullable = false)
  private PaymentMethodEnum method;
  
  @Column(nullable = false)
  private LocalDate createdDate;
  
  @Column
  private String discountCode;

  @ManyToOne
  @JoinColumn(name = "clientId", nullable = false)
  private Client client;

  @OneToOne
  @JoinColumn(name = "subscriptionId", nullable = false)
  private Subscription subscription;

  protected Payment() {}

  public Payment(Integer id, Float value, PaymentMethodEnum method, String discountCode, Client client, Subscription subscription) {
    this.id = id;
    this.client = client;
    this.subscription = subscription;
    this.value = value;
    this.method = method;
    this.createdDate = LocalDate.now();
    this.discountCode = discountCode;
  }
}
