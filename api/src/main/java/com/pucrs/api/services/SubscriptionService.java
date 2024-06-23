package com.pucrs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucrs.api.repositories.SubscriptionRepository;

@Service
public class SubscriptionService {

  @Autowired
  private SubscriptionRepository subscriptionRepository;
}
