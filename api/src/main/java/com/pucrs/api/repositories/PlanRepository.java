package com.pucrs.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucrs.api.models.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {}
