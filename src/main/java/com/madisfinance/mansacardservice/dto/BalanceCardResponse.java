package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceCardResponse implements Serializable {
    private String operationType;     // "getAccountBalance"
    private String accountBalance;    // Account balance
    private String balanceStatusDate; // Date of balance status
    private String currentDebit;      // Current debit amount
    private String currentCredit;     // Current credit amount
    private String currentBalance;    // Current balance
    private String status;            // "SUCCESS"

    // Getters and Setters
}
