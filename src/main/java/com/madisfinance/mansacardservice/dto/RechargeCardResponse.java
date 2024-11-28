package com.madisfinance.mansacardservice.dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeCardResponse implements Serializable {
    private String operationType;     // "createAccountTransaction"
    private String code;              // Response code (e.g., 200)
    private String transactionRefSequence; // Transaction reference sequence
    private String montant;           // Transaction amount
    private String sens;              // Transaction type
    private String status;            // "SUCCESS"

    // Getters and Setters
}

