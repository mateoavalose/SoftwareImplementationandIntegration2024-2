package com.exercise.SpringBoot.Exercise.Product.controllers;

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
import com.exercise.SpringBoot.Exercise.Product.modelEntity.Product;
import com.exercise.SpringBoot.Exercise.Product.services.IProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/findAll")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product) {
        Map<String, String> response = new HashMap<>();
        try {
            productService.save(product);
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        response.put("message", "Product saved successfully");
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (product == null) {
            response.put("message", "Product not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Product productToUpdate = productService.findById(id);
        if(productToUpdate == null)
            throw new RuntimeException("Product not found");
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        return productService.save(productToUpdate);
    }
}
