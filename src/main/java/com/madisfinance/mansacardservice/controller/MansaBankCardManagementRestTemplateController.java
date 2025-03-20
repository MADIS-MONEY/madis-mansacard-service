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
import com.madisfinance.mansacardservice.dto.exception.InvalidAgentCredentialsException;
import com.madisfinance.mansacardservice.service.MansaBankCardManagementRestTemplateService;

@CrossOrigin("*")
@RestController
@RequestMapping("/card/mansa")
public class MansaBankCardManagementRestTemplateController {

    private final MansaBankCardManagementRestTemplateService service;

    public MansaBankCardManagementRestTemplateController(MansaBankCardManagementRestTemplateService service) {
        this.service = service;
    }

    @PostMapping("/create-card")
    public CreateCardResponse createCard(@RequestBody CreateCardRequest request) throws InvalidAgentCredentialsException {
        return service.createCard(request);
    }

    @PostMapping("/order-stock")
    public OrderStockResponse orderStock(@RequestBody OrderStockRequest request) throws InvalidAgentCredentialsException {
        return service.orderStock(request);
    }

    @PostMapping("/operation-card")
    public OperationCardResponse operationCard(@RequestBody OperationCardRequest request) throws InvalidAgentCredentialsException {
        return service.operationCard(request);
    }

    @PostMapping("/balance-card")
    public BalanceCardResponse getBalance(@RequestBody BalanceCardRequest request) throws InvalidAgentCredentialsException {
        return service.getBalance(request);
    }

    @PostMapping("/recharge-card")
    public RechargeCardResponse rechargeCard(@RequestBody RechargeCardRequest request) throws InvalidAgentCredentialsException {
        return service.rechargeCard(request);
    }

    @PostMapping("/history")
    public HistoryCardResponse getHistory(@RequestBody HistoryCardRequest request) throws InvalidAgentCredentialsException {
        return service.getHistory(request);
    }
}
