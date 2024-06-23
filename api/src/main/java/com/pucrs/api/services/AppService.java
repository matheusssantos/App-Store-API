package com.pucrs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.repositories.AppRepository;

@Service
public class AppService {

  @Autowired
  private AppRepository appRepository;
}
