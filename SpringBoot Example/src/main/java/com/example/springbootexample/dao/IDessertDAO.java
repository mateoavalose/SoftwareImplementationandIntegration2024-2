package com.example.springbootexample.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springbootexample.modelEntity.Dessert;

public interface IDessertDAO extends JpaRepository<Dessert, Long> {
    public List<Dessert> findByName(String name);

    public List<Dessert> findByNameAndPrice(String name, Double price);

    public List<Dessert> findByNameLike(String name);

    @Query("SELECT d FROM Dessert d WHERE d.name = ?1")
    public List<Dessert> findAllPostres(@Param("name") String name);
}