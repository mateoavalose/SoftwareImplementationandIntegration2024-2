package com.exercise.SpringBoot.Exercise.Customer.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.SpringBoot.Exercise.Customer.modelEntity.Customer;
import com.exercise.SpringBoot.Exercise.Customer.services.ICustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/findAll")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer) {
        Map<String, String> response = new HashMap<>();
        try {
            customerService.save(customer);
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        response.put("message", "Customer saved successfully");
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (customer == null) {
            response.put("message", "Customer not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(customer);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        Customer customerToUpdate = customerService.findById(id);
        if(customerToUpdate == null)
            throw new RuntimeException("Customer not found");
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());
        customerToUpdate.setAddress(customer.getAddress());
        return customerService.save(customerToUpdate);
    }
}
