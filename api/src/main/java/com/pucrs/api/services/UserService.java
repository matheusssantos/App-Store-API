package com.pucrs.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.User;
import com.pucrs.api.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> todos() {
    return userRepository.findAll();
  }

  public User acharPorId(Integer id) {
    return userRepository.findById(id).orElse(null);
  }
}


