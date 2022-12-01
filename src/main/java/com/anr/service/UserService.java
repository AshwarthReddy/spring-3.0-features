package com.anr.service;

import com.anr.model.User;

public interface UserService {
    User createUser(User user);

    User findByUserId(Integer id);
}
