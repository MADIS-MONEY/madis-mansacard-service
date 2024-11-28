package com.madisfinance.mansacardservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.madisfinance.mansacardservice.dto.BalanceCardRequest;
import com.madisfinance.mansacardservice.dto.BalanceCardResponse;
import com.madisfinance.mansacardservice.dto.CreateCardRequest;
import com.madisfinance.mansacardservice.dto.CreateCardResponse;
import com.madisfinance.mansacardservice.dto.HistoryCardRequest;
import com.madisfinance.mansacardservice.dto.HistoryCardResponse;
import com.madisfinance.mansacardservice.dto.OperationCardRequest;
import com.madisfinance.mansacardservice.dto.OperationCardResponse;
import com.madisfinance.mansacardservice.dto.OrderStockRequest;
import com.madisfinance.mansacardservice.dto.OrderStockResponse;
import com.madisfinance.mansacardservice.dto.RechargeCardRequest;
import com.madisfinance.mansacardservice.dto.RechargeCardResponse;

import reactor.core.publisher.Mono;

@Service
public class MansaBankCardManagementService extends GenericApiService { 

    public MansaBankCardManagementService(WebClient.Builder webClientBuilder) {
        super(webClientBuilder, "https://dev-api.mansabank.com");
    }

    public Mono<CreateCardResponse> createCard(CreateCardRequest request) {
        return post( "/create_card/madis", request, CreateCardResponse.class);
    }

    public Mono<OrderStockResponse> orderStock(OrderStockRequest request) {
        return post( "/order_stock/madis", request, OrderStockResponse.class);
    }

    public Mono<OperationCardResponse> operationCard(OperationCardRequest request) {
        return post( "/operation_card/madis", request, OperationCardResponse.class);
    }

    public Mono<BalanceCardResponse> getBalance(BalanceCardRequest request){
        return post( "/balance_card/madis", request, BalanceCardResponse.class);
    }

    public Mono<RechargeCardResponse> rechargeCard(RechargeCardRequest request) {
        return post( "/recharge_card/madis", request, RechargeCardResponse.class);
    }

    public Mono<HistoryCardResponse> getHistory(HistoryCardRequest request){
        return post( "/history/madis", request, HistoryCardResponse.class);
    }
}
