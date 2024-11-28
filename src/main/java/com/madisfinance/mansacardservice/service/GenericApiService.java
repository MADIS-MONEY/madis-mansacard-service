package com.madisfinance.mansacardservice.service;


import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public abstract class GenericApiService {

    protected final WebClient webClient;

    protected GenericApiService(WebClient.Builder webClientBuilder, String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    protected <T> Mono<T> post(String uri, Object requestBody, Class<T> responseType) {
        return webClient.post()
            .uri(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .body((BodyInserter<?, ? super ClientHttpRequest>) Mono.just(requestBody))
            .retrieve()
            .bodyToMono(responseType);
    }

    // Other common methods for handling error responses, authentication, etc.
}
