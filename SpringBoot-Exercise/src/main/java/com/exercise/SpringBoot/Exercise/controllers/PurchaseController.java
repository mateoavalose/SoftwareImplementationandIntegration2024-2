package com.exercise.SpringBoot.Exercise.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.SpringBoot.Exercise.modelEntity.Purchase;
import com.exercise.SpringBoot.Exercise.services.IPurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private IPurchaseService purchaseService;

    @GetMapping("/findAll")
    public List<Purchase> getPurchases() {
        return purchaseService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePurchase(Purchase purchase) {
        Map<String, String> response = new HashMap<>();
        try {
            purchaseService.save(purchase);
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        response.put("message", "Purchase saved successfully");
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePurchase(Long id) {
        purchaseService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getPurchase(Long id) {
        Purchase purchase = purchaseService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (purchase == null) {
            response.put("message", "Purchase not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(purchase);
    }

    @PutMapping("/update/{id}")
    public Purchase updatePurchase(Purchase purchase, Long id) {
        Purchase purchaseToUpdate = purchaseService.findById(id);
        if(purchaseToUpdate == null)
            throw new RuntimeException("Purchase not found");
        return purchaseService.save(purchase);
    }

    @GetMapping("/client/{client_id}")
    public List<Purchase> getCustomerOrders(Long customer_id){
        return purchaseService.getCustomerOrders(customer_id);
    }
}
