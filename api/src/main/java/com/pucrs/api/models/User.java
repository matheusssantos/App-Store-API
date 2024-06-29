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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String password;

  @JsonIgnore
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<App> apps = new ArrayList<App>();
  
  @JsonIgnore
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Plan> plans = new ArrayList<Plan>();
  
  protected User() {}

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<App> getApps() {
    return apps;
  }

  public void setApps(List<App> apps) {
    this.apps = apps;
  }

  public List<Plan> getPlans() {
    return plans;
  }

  public void setPlans(List<Plan> plans) {
    this.plans = plans;
  }
} 
