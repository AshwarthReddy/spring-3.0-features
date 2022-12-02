package com.anr.service.impl;

import com.anr.httpclient.PeopleClient;
import com.anr.exception.UserNotFound;
import com.anr.model.People;
import com.anr.model.User;
import com.anr.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final PeopleClient peopleClient;

    @Override
    public User createUser(User user) {

        People people = peopleClient.savePeople(People.builder().id(String.valueOf(user.id())).name(user.name()).build());
        log.info("people saved successfully");


        return new User(Integer.valueOf(people.getId()), people.getName());
    }

    @Override
    public User findByUserId(Integer id) {

        People people = peopleClient.getPeople(id);
        log.info("people called successfully");
        return new User(Integer.valueOf(people.getId()), people.getName());
    }
}
