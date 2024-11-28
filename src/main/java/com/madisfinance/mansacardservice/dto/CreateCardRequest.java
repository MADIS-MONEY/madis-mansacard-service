package com.madisfinance.mansacardservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequest implements Serializable {
    private String numeroAgent;       // Agent's phone number
    private String numeroClient;      // Client's phone number
    private String prenomClient;      // Client's first name
    private String nomClient;         // Client's last name
    private String idTypeClient;      // Type of client ID (e.g., "PASS" for passport, "CNI" for identity card)
    private String idScanVerso;       // Back scan of the identity card (base64)
    private String idScanRecto;       // Front scan of the identity card (base64)
    private String idNumberClient;    // Identity card number
    private String pinAgent;          // Agent's encrypted PIN

    // Getters and Setters through @Data
}

