package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeCardRequest implements Serializable {
    private String numeroAgent;       // Agent's phone number
    private String numeroClient;      // Client's phone number
    private String compte;            // Linked account number
    private String montant;           // Transaction amount
    private String sens;              // Transaction type (N1 for credit, UL for debit)
    private String pinAgent;          // Agent's encrypted PIN

    // Getters and Setters
}

