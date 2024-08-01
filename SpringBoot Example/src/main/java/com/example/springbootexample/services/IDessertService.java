package com.example.springbootexample.services;

import com.example.springbootexample.modelEntity.Dessert;
import java.util.*;

public interface IDessertService {
    public List<Dessert> findAll();
    public Dessert save(Dessert dessert);
}