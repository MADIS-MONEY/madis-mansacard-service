package com.madisfinance.mansacardservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madisfinance.mansacardservice.dto.VirtualCard;
import com.madisfinance.mansacardservice.service.VirtualCardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/card")
public class VirtualCardController {
    private final VirtualCardService cardService;

    public VirtualCardController(VirtualCardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/generate")
    public VirtualCard createVirtualCard() {
        return cardService.createVirtualCard();
    }
}
