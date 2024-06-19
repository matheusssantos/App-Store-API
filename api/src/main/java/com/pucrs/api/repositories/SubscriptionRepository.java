package com.pucrs.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucrs.api.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {}
