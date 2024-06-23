package com.pucrs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;
}
