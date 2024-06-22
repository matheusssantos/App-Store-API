package com.pucrs.api.models.repositories;

import java.util.List;

import com.pucrs.api.models.User;

public interface IUserRepository {
    List<User> todos();
    User acharPorId(Integer id);
}
