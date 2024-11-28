package com.madisfinance.mansacardservice.dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryCardRequest implements Serializable {
    private String numeroAgent;       // Agent's phone number
    private String numeroClient;      // Client's phone number
    private String compte;            // Linked account number
    private String startDt;           // Start date (ISO format)
    private String endDt;             // End date (ISO format)
    private String pinAgent;          // Agent's encrypted PIN

    // Getters and Setters
}

