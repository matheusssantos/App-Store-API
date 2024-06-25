package com.pucrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.Plan;
import com.pucrs.api.services.PlanService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/plans")
public class PlanController {

  @Autowired
  private PlanService planService;

  @GetMapping("")
  public ResponseEntity<List<Plan>> findAll() {
    List<Plan> plans = this.planService.todos();
    return ResponseEntity.ok(plans);
  }
}
