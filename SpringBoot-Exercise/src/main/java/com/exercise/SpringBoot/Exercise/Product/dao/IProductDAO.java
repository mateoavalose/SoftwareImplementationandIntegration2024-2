package com.exercise.SpringBoot.Exercise.Product.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.exercise.SpringBoot.Exercise.Product.modelEntity.Product;

public interface IProductDAO extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    public List<Product> findAvailableProducts();
}
