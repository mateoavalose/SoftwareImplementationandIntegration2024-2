package com.exercise.SpringBoot.Exercise.Purchase.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.SpringBoot.Exercise.Purchase.dao.IPurchaseDAO;
import com.exercise.SpringBoot.Exercise.Purchase.modelEntity.Purchase;

@Service
public class PurchaseService implements IPurchaseService {
    @Autowired
    private IPurchaseDAO purchaseDAO;

    @Override
    public List<Purchase> findAll() {
        return purchaseDAO.findAll();
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseDAO.save(purchase);
    }

    @Override
    public Purchase findById(Long id) {
        return purchaseDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        purchaseDAO.deleteById(id);
    }

    @Override
    public List<Purchase> getCustomerOrders(Long id) {
        return purchaseDAO.getCustomerOrders(id);
    }
}
