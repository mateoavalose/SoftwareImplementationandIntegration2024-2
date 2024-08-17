package com.example.springbootexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootexample.modelEntity.Dessert;
import com.example.springbootexample.dao.IDessertDAO;
import java.util.*;

@Service
public class DessertService implements IDessertService {
    @Autowired
    private IDessertDAO dessertDAO;
    @Override
    public List<Dessert> findAll() {
        return dessertDAO.findAll();
    }
    @Override
    public Dessert save(Dessert dessert) {
        return dessertDAO.save(dessert);
    }
    @Override
    public Dessert findById(Long id) {
        return dessertDAO.findById(id).orElse(null);
    }
    @Override
    public void deleteById(Long id) {
        dessertDAO.deleteById(id);
    }
}