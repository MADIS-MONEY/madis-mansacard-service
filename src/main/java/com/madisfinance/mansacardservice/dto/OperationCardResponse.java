package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationCardResponse implements Serializable {
    private String operationType;     // "updateCardStatus"
    private String timestamp;         // Timestamp of the operation
    private String compteClient;      // Client's account number
    private String numeroClient;      // Client's card number

    // Getters and Setters
}

