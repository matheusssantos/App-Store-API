package com.pucrs.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.models.App;
import com.pucrs.api.models.Plan;
import com.pucrs.api.repositories.PlanRepository;

@Service
public class PlanService {

  @Autowired
  private PlanRepository planRepository;

  public PlanService(PlanRepository planRepository){
    this.planRepository = planRepository;
  }

public Plan acharPorId(Integer id) {
    return planRepository.findById(id).orElse(null);
}


public List<Plan> todos() {
    return planRepository.findAll();
}
}
