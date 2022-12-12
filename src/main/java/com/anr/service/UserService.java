package com.anr.service;

import com.anr.model.People;

public interface UserService {
    People createUser(People user);

    People findByUserId(Integer id);
}
