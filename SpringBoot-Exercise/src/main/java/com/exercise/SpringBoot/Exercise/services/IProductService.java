package com.exercise.SpringBoot.Exercise.services;

import com.exercise.SpringBoot.Exercise.modelEntity.Product;
import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public Product findById(Long id);
    public void deleteById(Long id);
}
