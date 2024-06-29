package com.pucrs.api.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucrs.api.enums.PaymentMethodEnum;

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

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "clientId", nullable = false)
  private Client client;

  @JsonIgnore
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  public PaymentMethodEnum getMethod() {
    return method;
  }

  public void setMethod(PaymentMethodEnum method) {
    this.method = method;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public String getDiscountCode() {
    return discountCode;
  }

  public void setDiscountCode(String discountCode) {
    this.discountCode = discountCode;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Subscription getSubscription() {
    return subscription;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }
}
