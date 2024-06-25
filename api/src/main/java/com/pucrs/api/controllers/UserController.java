package com.pucrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.User;
import com.pucrs.api.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  @GetMapping("")
  public ResponseEntity<List<User>> findAll() {
    List<User> users = this.userService.todos();
    return ResponseEntity.ok(users);
  }
  
}
