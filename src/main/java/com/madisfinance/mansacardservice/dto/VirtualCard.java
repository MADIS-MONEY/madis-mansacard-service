package com.madisfinance.mansacardservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
public class VirtualCard implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    @Version
    @Builder.Default
    private Integer version = 0; // Initialize version to prevent null values

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @PrePersist
    protected void onCreate() {
        lastModified = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModified = new Date();
    }

    public VirtualCard(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.version = 0; // Ensure version is initialized
    }
}
