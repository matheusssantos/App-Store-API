package com.pucrs.models;

import java.time.LocalDate;

import com.pucrs.enums.SubscriptionStatusEnum;

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
@Table(name = "subscriptions")
public class Subscription {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private LocalDate duaDate;
  
  @Column(nullable = false)
  private LocalDate startDate;
  
  @Column(nullable = false)
  private SubscriptionStatusEnum status;

  @ManyToOne
  @JoinColumn(name = "appId", nullable = false)
  private App app;
 
  @ManyToOne
  @JoinColumn(name = "planId", nullable = false)
  private Plan plan;
  
  @ManyToOne
  @JoinColumn(name = "clientId", nullable = false)
  private Client client; 

  @OneToOne(mappedBy = "subscription")
  private Payment payment;

  protected Subscription() {}

  public Subscription(Integer id, LocalDate duaDate, Client client, App app, Plan plan, Payment payment) {
    this.id = id;
    this.duaDate = duaDate;
    this.startDate = LocalDate.now();
    this.status = SubscriptionStatusEnum.NEW;
    this.app = app;
    this.plan = plan;
    this.client = client;
    this.payment = payment;
  }
}
