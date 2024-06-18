package com.pucrs.models;

import java.time.LocalDate;

import com.pucrs.enums.PaymentMethodEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer subscriptionID;

  @Column(nullable = false)
  private Integer clientId;

  @Column(nullable = false)
  private Float value;
  
  @Column(nullable = false)
  private PaymentMethodEnum method;
  
  @Column(nullable = false)
  private LocalDate createdDate;
  
  @Column
  private String discountCode;

  protected Payment() {}

  public Payment(Integer id, Integer subscriptionID, Integer clientId, Float value, PaymentMethodEnum method, String discountCode) {
    this.id = id;
    this.subscriptionID = subscriptionID;
    this.clientId = clientId;
    this.value = value;
    this.method = method;
    this.createdDate = LocalDate.now();
    this.discountCode = discountCode;
  }
}
