package com.anr.service.impl;

import com.anr.httpclient.PeopleClient;
import com.anr.model.People;
import com.anr.service.UserService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PeopleClient peopleClient;

    private final ObservationRegistry observationRegistry;

    @Override
    public People createUser(People user) {

        People posts = Observation
                .createNotStarted("json-place-holder.create-users", observationRegistry)
                .lowCardinalityKeyValue("some-value", "100")
                .observe(() -> peopleClient.savePeople(user));


        People people = peopleClient.savePeople(user);


        return people;

    }

    @Override
    public People findByUserId(Integer id) {

        return peopleClient.getPeople(id);
    }
}
