package com.pucrs.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucrs.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
