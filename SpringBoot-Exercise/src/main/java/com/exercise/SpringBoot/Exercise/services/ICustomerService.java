package com.exercise.SpringBoot.Exercise.services;

import com.exercise.SpringBoot.Exercise.modelEntity.Customer;
import java.util.*;

public interface ICustomerService {
    public List<Customer> findAll();
    public Customer save(Customer customer);
    public Customer findById(Long id);
    public void deleteById(Long id);
}
