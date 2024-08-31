package com.exercise.SpringBoot.Exercise.Customer.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.SpringBoot.Exercise.Customer.modelEntity.Customer;

public interface ICustomerDAO extends JpaRepository<Customer, Long> {
    public List<Customer> findByName(String name);

    public List<Customer> findByEmail(String email);
    
    public List<Customer> findByPhone(Integer phone);
}
