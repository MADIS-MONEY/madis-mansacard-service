package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationCardRequest implements Serializable{
    private String numeroAgent;       // Agent's phone number
    private String compte;            // Linked account number
    private String numeroClient;      // Encrypted card number
    private String operation;         // Operation to perform (A, L, E, D, etc.)
    private String pinAgent;          // Agent's encrypted PIN

    // Getters and Setters
}
