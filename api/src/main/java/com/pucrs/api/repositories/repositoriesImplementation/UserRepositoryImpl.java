package com.pucrs.api.repositories.repositoriesImplementation;

import java.util.List;
import com.pucrs.api.models.User;
import com.pucrs.api.models.repositories.IUserRepository;
import com.pucrs.api.repositories.UserRepository;

public class UserRepositoryImpl implements IUserRepository {
    private UserRepository userRep;

    public UserRepositoryImpl(UserRepository userRep) {
        this.userRep = userRep;
    }

    @Override
    public List<User> todos() {
        return userRep.findAll();
    }

    @Override
    public User acharPorId(Integer id) {
        return userRep.findById(id).orElse(null);
    }

    

}