package com.exercise.SpringBoot.Exercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.SpringBoot.Exercise.modelEntity.Purchase;

public interface IPurchaseDAO extends JpaRepository<Purchase, Long> {
    
}
