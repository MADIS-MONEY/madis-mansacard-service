package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceCardRequest implements Serializable {
    private String numeroAgent;       // Agent's phone number
    private String numeroClient;      // Encrypted card number
    private String compte;            // Linked account number
    private String pinAgent;          // Agent's encrypted PIN

    // Getters and Setters
}

