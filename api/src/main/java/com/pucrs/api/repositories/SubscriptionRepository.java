package com.pucrs.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucrs.api.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    // List<Subscription> findByType(String type);
    // List<Subscription> findByClient(Integer codClient);
    // List<Subscription> findByApp(Integer codApp);
    // boolean isActive(Integer codSubscription);
}
