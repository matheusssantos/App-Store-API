package com.pucrs.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "plans")
public class Plan {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private Float discountPercent;

  @Column(nullable = false)
  private Float price;

  @Column(nullable = false)
  private Integer availableDays;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Subscription> subscriptions = new ArrayList<Subscription>();

  protected Plan() {}

  public Plan(Integer id, String name, Float discountPercent, Float price, Integer availableDays, User user) {
    this.id = id;
    this.user = user;
    this.name = name;
    this.discountPercent = discountPercent;
    this.price = price;
    this.availableDays = availableDays;
  }
}
