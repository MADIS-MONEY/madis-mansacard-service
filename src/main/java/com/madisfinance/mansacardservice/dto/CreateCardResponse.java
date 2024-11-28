package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardResponse  implements Serializable {
    private String operationType;     // "createCreditCard"
    private String status;            // "SUCCESS"
    private String code;              // Response code (e.g., 200)
    private String numeroClient;      // Client's phone number
    private String numeroAgent;       // Agent's phone number
    private String compteClient;      // Client's account number
    private String carte;             // Credit card number (masked)
    private String address;           // Client's address
    private String timestamp;         // Timestamp of the operation

    // Getters and Setters through @Data
}

