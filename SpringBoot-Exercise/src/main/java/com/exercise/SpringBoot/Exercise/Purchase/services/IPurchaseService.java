package com.exercise.SpringBoot.Exercise.Purchase.services;

import java.util.List;
import com.exercise.SpringBoot.Exercise.Purchase.modelEntity.Purchase;

public interface IPurchaseService {
    public List<Purchase> findAll();

    public Purchase save(Purchase Purchase);

    public Purchase findById(Long id);

    public void deleteById(Long id);

    public List<Purchase> getCustomerOrders(Long id);
}
