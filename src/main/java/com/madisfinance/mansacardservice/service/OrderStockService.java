package com.madisfinance.mansacardservice.service;

import org.springframework.web.reactive.function.client.WebClient;

import com.madisfinance.mansacardservice.dto.OrderStockRequest;
import com.madisfinance.mansacardservice.dto.OrderStockResponse;

import reactor.core.publisher.Mono;

public class OrderStockService  extends GenericApiService{ 

    public OrderStockService(WebClient.Builder webClientBuilder) {
        super(webClientBuilder, "https://dev-api.mansabank.com");
    }

    public Mono<OrderStockResponse> orderStock(OrderStockRequest request) {
        return post("/order_stock/madis", request, OrderStockResponse.class);
    }
}
