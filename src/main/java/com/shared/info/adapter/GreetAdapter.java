package com.shared.info.adapter;

import com.shared.info.port.GreetPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
public class GreetAdapter implements GreetPort {

    @Autowired
    @Qualifier("greetService")
    private GraphQlClient graphQlClient;

    @Override
    public String greet(String name) {
        return Objects.requireNonNull(graphQlClient.documentName("greet-user")
                .variable("name", name)
                .retrieve("greeting")
                .toEntity(String.class)).block();
    }
}
