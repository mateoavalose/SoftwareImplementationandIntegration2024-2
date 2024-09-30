package com.FashionShow.FashionShow_Project.Portfolio.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Portfolio.modelEntity.Portfolio;

public interface IPortfolioService {
    public List<Portfolio> findAll();

    public Portfolio save(Portfolio portfolio);

    public Portfolio findById(Long id);

    public void delete(Long id);
}
