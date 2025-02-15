package com.madisfinance.mansacardservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private static final Logger logger = LoggerFactory.getLogger(VirtualCardService.class);

    public VirtualCardController(VirtualCardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/generate")
    public ResponseEntity<VirtualCard> createVirtualCard() {
        try {
            // Log the attempt to generate a virtual card
            logger.info("Attempting to create a virtual card...");
            
            // Generate the virtual card via the service
            VirtualCard card = cardService.createVirtualCard();
            
            // Log success
            logger.info("Successfully created a virtual card with card number: {}", card.getCardNumber());
            
            // Return the card with a 201 Created status
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the error
            logger.error("Error creating virtual card: {}", e.getMessage());
            
            // Return a 500 Internal Server Error if something goes wrong
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
