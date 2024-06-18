package com.pucrs.models;

import java.time.LocalDate;

import com.pucrs.enums.SubscriptionStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer userId;

  @Column(nullable = false)
  private Integer appId;

  @Column(nullable = false)
  private Integer planId;

  @Column(nullable = false)
  private LocalDate duaDate;
  
  @Column(nullable = false)
  private LocalDate startDate;
  
  @Column(nullable = false)
  private SubscriptionStatusEnum status;

  protected Subscription() {}

  public Subscription(Integer id, Integer userId, Integer appId, Integer planId, LocalDate duaDate) {
    this.id = id;
    this.userId = userId;
    this.appId = appId;
    this.planId = planId;
    this.duaDate = duaDate;
    this.startDate = LocalDate.now();
    this.status = SubscriptionStatusEnum.NEW;
  }
}
