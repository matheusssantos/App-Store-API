package com.pucrs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.repositories.PlanRepository;

@Service
public class PlanService {

  @Autowired
  private PlanRepository planRepository;
}
