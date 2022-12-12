package com.anr.config;

import com.anr.httpclient.PeopleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {

    @Bean
    public PeopleClient peopleClient(WebClient.Builder builder) {
        WebClient webClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        PeopleClient peopleClient = factory.createClient(PeopleClient.class);
        return peopleClient;


    }
}
