package com.pucrs.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucrs.api.models.App;

@Repository
public interface AppRepository extends JpaRepository<App, Integer> {}
