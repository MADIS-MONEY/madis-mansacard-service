package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStockRequest implements Serializable {
    private String numeroAgent;       // Agent's phone number
    private String nombreCartes;      // Number of cards to create
    private String pinAgent;          // Agent's encrypted PIN

    // Getters and Setters
}

