package com.pucrs.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String email;
  
  @Column(nullable = false)
  private String password;
  
  @Column
  private String token;

  @OneToMany(mappedBy = "client")
  private List<Payment> payments = new ArrayList<Payment>();

  @OneToMany(mappedBy = "client")
  private List<Subscription> subscriptions = new ArrayList<Subscription>();

  protected Client() {}

  public Client(Integer id, String name, String email, String password, String token) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.token = token;
  }

}
