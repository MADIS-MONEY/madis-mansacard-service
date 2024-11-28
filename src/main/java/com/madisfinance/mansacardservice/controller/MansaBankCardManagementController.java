package com.madisfinance.mansacardservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.madisfinance.mansacardservice.service.MansaBankCardManagementService;

import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/card/mansa")
public class MansaBankCardManagementController {
    private final MansaBankCardManagementService mansaBankCardManagementService;

    public MansaBankCardManagementController(MansaBankCardManagementService mansaBankCardManagementService) {
        this.mansaBankCardManagementService = mansaBankCardManagementService;
    }

    @PostMapping("/create-card")
    public Mono<CreateCardResponse> createCard(@RequestBody CreateCardRequest request) {
        return mansaBankCardManagementService.createCard(request);
    }

    @PostMapping("/order-stock")
    public Mono<OrderStockResponse> orderStock(@RequestBody OrderStockRequest request) {
        return mansaBankCardManagementService.orderStock(request);
    }

    @PostMapping("/operation-card")
    public Mono<OperationCardResponse> operationCard(@RequestBody OperationCardRequest request) {
        return mansaBankCardManagementService.operationCard(request);
    }

    @PostMapping("/balance-card")
    public Mono<BalanceCardResponse> getBalance(@RequestBody BalanceCardRequest request) {
        return mansaBankCardManagementService.getBalance(request);
    }


    @PostMapping("/recharge-card")
    public Mono<RechargeCardResponse> rechargeCard(@RequestBody RechargeCardRequest request) {
        return mansaBankCardManagementService.rechargeCard(request);
    }

    @PostMapping("/history")
    public Mono<HistoryCardResponse> getHistory(@RequestBody HistoryCardRequest request) {
        return mansaBankCardManagementService.getHistory(request);
    }
}
