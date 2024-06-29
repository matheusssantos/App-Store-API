package com.pucrs.api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  @JsonIgnore
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(Float discountPercent) {
    this.discountPercent = discountPercent;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Integer getAvailableDays() {
    return availableDays;
  }

  public void setAvailableDays(Integer availableDays) {
    this.availableDays = availableDays;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Subscription> getSubscriptions() {
    return subscriptions;
  }

  public void setSubscriptions(List<Subscription> subscriptions) {
    this.subscriptions = subscriptions;
  }
}
