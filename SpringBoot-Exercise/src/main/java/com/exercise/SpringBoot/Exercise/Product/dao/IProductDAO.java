package com.exercise.SpringBoot.Exercise.Product.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.SpringBoot.Exercise.Product.modelEntity.Product;

public interface IProductDAO extends JpaRepository<Product, Long> {
    public List<Product> findByName(String name);

    public List<Product> findByPrice(Double price);
    
    public List<Product> findByStock(Integer stock);
}
