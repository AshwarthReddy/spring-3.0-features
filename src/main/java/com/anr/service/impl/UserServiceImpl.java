package com.anr.service.impl;

import com.anr.exception.UserNotFound;
import com.anr.model.User;
import com.anr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private List<User> USERS = new ArrayList<>();

    @Override
    public User createUser(User user) {

        USERS.add(user);

        return user;
    }

    @Override
    public User findByUserId(Integer id) {
        return USERS.stream().filter(Objects::nonNull)
                .filter(user -> user.id().equals(id))
                .findAny()
                .orElseThrow(() -> new UserNotFound("user not found"));
    }
}
