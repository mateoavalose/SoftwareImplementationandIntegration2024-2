package com.FashionShow.FashionShow_Project.Portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Portfolio.modelEntity.Portfolio;

public interface IPortfolioDAO extends JpaRepository<Portfolio, Long> {
    
}
