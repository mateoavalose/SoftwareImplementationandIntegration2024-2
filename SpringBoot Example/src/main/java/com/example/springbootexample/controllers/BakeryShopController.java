package com.example.springbootexample.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootexample.modelEntity.Dessert;
import com.example.springbootexample.services.IDessertService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;

@RestController()
@RequestMapping("/APIBakery")
public class BakeryShopController {
    @Autowired
    private IDessertService dessertService;

    @GetMapping("/EndpointCakes")
    public List<Dessert> getCakes() {
        return dessertService.findAll();
    }

    @PostMapping("/EndpointCakes")
    public ResponseEntity<?> saveCake(@Valid @RequestBody Dessert dessert) {
        Map<String, String> response = new HashMap<>();
        try {
            dessertService.save(dessert);
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(dessert);
    }
    @DeleteMapping("/EndpointCakes/{id}")
    public void deleteCake(@PathVariable Long id) {
        dessertService.deleteById(id);
    }

    @GetMapping("/EndpointCakes/{id}")
    public ResponseEntity<?> getCake(@PathVariable Long id) {
        Dessert dessert = dessertService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (dessert == null) {
            response.put("message", "Dessert not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(dessert);
    }

    @PutMapping("/EndpointCakes/{id}")
    public Dessert updateCake(@RequestBody Dessert dessert, @PathVariable Long id) {
        Dessert dessertToUpdate = dessertService.findById(id);
        if (dessertToUpdate == null) {
            throw new RuntimeException("Dessert not found");
        }
        dessertToUpdate.setName(dessert.getName());
        dessertToUpdate.setPrice(dessert.getPrice());
        return dessertService.save(dessertToUpdate);
    }
}