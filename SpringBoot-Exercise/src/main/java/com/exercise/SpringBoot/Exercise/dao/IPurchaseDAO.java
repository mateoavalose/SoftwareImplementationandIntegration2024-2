package com.exercise.SpringBoot.Exercise.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exercise.SpringBoot.Exercise.modelEntity.Purchase;

public interface IPurchaseDAO extends JpaRepository<Purchase, Long> {
    @Query("SELECT p FROM Purchase p WHERE p.customer_id = :customer_id")
    public List<Purchase> getCustomerOrders(@Param("customer_id") Long customer_id);
}
