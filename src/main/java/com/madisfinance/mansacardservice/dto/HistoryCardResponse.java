package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryCardResponse implements Serializable {
    private String operationType; // "searchTransactions"
    private String code; // Response code (e.g., 200)
    private String status; // "SUCCESS"
    private int nbTransactions; // Number of transactions
    private String totalCreditAmt; // Total credit amount
    private String totalDebitAmt; // Total debit amount
    private List<Transaction> transactions; // List of transactions

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Transaction implements Serializable {
        private String transId; // Transaction ID
        private String label; // Transaction label (description)
        private String transSign; // Transaction sign ("C" for credit, "D" for debit)
        private String transDate; // Transaction date
        private String amt; // Transaction amount

        // Getters and Setters
    }

    // Getters and Setters
}
