package com.pucrs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apps")
public class App {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer userId;

  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private Float price;

  protected App() {}

  public App(Integer id, Integer userId, String name, String description, Float price) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
