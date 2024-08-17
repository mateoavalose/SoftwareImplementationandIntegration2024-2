package com.example.springbootexample.services;

import com.example.springbootexample.modelEntity.Dessert;
import java.util.*;

public interface IDessertService {
    public List<Dessert> findAll();
    public Dessert save(Dessert dessert);
    public Dessert findById(Long id);
    public void deleteById(Long id);
}