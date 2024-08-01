package com.example.springbootexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootexample.modelEntity.Dessert;

public interface IDessertDAO extends JpaRepository<Dessert, Long> {

}