package com.FashionShow.FashionShow_Project.Portfolio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FashionShow.FashionShow_Project.Portfolio.modelEntity.Portfolio;
import com.FashionShow.FashionShow_Project.Portfolio.services.IPortfolioService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping("/all")
    public List<Portfolio> findAll() {
        return portfolioService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Portfolio portfolio) {
        Map<String, String> response = new HashMap<>();
        try {
            portfolioService.save(portfolio);
            response.put("message", "Portfolio saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(portfolio);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Portfolio portfolio = portfolioService.findById(id);
        if (portfolio == null) {
            response.put("message", "Portfolio not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(portfolio);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            portfolioService.delete(id);
            response.put("message", "Portfolio deleted successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }
}
