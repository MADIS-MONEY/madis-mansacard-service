package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStockResponse implements Serializable{
    private String operationType;     // "orderStockCards"
    private String timestamp;         // Timestamp of the operation
    private String batchNumber;       // Batch number of created cards

    // Getters and Setters
}
