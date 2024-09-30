package com.FashionShow.FashionShow_Project.Portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Portfolio.dao.IPortfolioDAO;
import com.FashionShow.FashionShow_Project.Portfolio.modelEntity.Portfolio;

@Service
public class PortfolioService implements IPortfolioService {
    @Autowired
    private IPortfolioDAO portfolioDAO;

    @Override
    public List<Portfolio> findAll() {
        return portfolioDAO.findAll();
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioDAO.save(portfolio);
    }

    @Override
    public Portfolio findById(Long id) {
        return portfolioDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        portfolioDAO.deleteById(id);
    }
}
