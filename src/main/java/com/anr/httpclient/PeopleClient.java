package com.anr.httpclient;

import com.anr.model.People;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange(url = "/users")
public interface PeopleClient {

    @PostExchange
    People savePeople(@RequestBody People people);

    @GetExchange("/{id}")
    People getPeople(@PathVariable Integer id);
}
