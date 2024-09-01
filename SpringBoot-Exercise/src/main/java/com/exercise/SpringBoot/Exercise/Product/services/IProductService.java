package com.exercise.SpringBoot.Exercise.Product.services;

import java.util.List;
import com.exercise.SpringBoot.Exercise.Product.modelEntity.Product;

public interface IProductService {
    public List<Product> findAll();

    public Product save(Product product);

    public Product findById(Long id);

    public void deleteById(Long id);

    public List<Product> findAvailableProducts();    
}
