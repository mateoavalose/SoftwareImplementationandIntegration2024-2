package com.example.springbootexample.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootexample.modelEntity.Dessert;
import com.example.springbootexample.services.IDessertService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Dessert saveCake(@RequestBody Dessert dessert) {
        return dessertService.save(dessert);
    }
}