package com.madisfinance.mansacardservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.madisfinance.mansacardservice.dto.CreateCardRequest;
import com.madisfinance.mansacardservice.dto.CreateCardResponse;

import reactor.core.publisher.Mono;

@Service
public class CreateCardService extends GenericApiService { 

    public CreateCardService(WebClient.Builder webClientBuilder) {
        super(webClientBuilder, "https://dev-api.mansabank.com");
    }

    public Mono<CreateCardResponse> createCard(CreateCardRequest request) {
        return post( "/create_card/madis", request, CreateCardResponse.class);
    }
}
