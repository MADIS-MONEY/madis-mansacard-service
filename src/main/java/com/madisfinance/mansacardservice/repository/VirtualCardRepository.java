package com.madisfinance.mansacardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madisfinance.mansacardservice.dto.VirtualCard;

public interface VirtualCardRepository extends JpaRepository<VirtualCard,Long> {
    
}
