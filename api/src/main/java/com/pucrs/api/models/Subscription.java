package com.pucrs.api.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucrs.api.enums.SubscriptionStatusEnum;

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

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "appId", nullable = false)
  private App app;
 
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "planId", nullable = false)
  private Plan plan;
  
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "clientId", nullable = false)
  private Client client; 

  @JsonIgnore
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getDuaDate() {
    return duaDate;
  }

  public void setDuaDate(LocalDate duaDate) {
    this.duaDate = duaDate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public SubscriptionStatusEnum getStatus() {
    return status;
  }

  public void setStatus(SubscriptionStatusEnum status) {
    this.status = status;
  }

  public App getApp() {
    return app;
  }

  public void setApp(App app) {
    this.app = app;
  }

  public Plan getPlan() {
    return plan;
  }

  public void setPlan(Plan plan) {
    this.plan = plan;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
}
