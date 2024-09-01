package com.exercise.SpringBoot.Exercise.Customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.SpringBoot.Exercise.Customer.modelEntity.Customer;

public interface ICustomerDAO extends JpaRepository<Customer, Long> {
}
