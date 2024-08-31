package com.exercise.SpringBoot.Exercise.Customer.services;

import java.util.*;
import com.exercise.SpringBoot.Exercise.Customer.modelEntity.Customer;

public interface ICustomerService {
    public List<Customer> findAll();

    public Customer save(Customer customer);

    public Customer findById(Long id);

    public void deleteById(Long id);
}
