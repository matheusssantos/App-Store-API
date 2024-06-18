package com.pucrs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plans")
public class Plan {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer userId;

  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private Float discountPercent;

  @Column(nullable = false)
  private Float price;

  @Column(nullable = false)
  private Integer availableDays;

  protected Plan() {}

  public Plan(Integer id, Integer userId, String name, Float discountPercent, Float price, Integer availableDays) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.discountPercent = discountPercent;
    this.price = price;
    this.availableDays = availableDays;
  }
}
