package com.exercise.SpringBoot.Exercise.services;

import com.exercise.SpringBoot.Exercise.modelEntity.Customer;
import com.exercise.SpringBoot.Exercise.dao.ICustomerDAO;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerDAO customerDAO;
    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        customerDAO.deleteById(id);
    }
}
