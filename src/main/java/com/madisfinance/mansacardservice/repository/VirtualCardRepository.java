package com.madisfinance.mansacardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madisfinance.mansacardservice.dto.VirtualCard;

@Repository
public interface VirtualCardRepository extends JpaRepository<VirtualCard,Long> {
    
}
