package com.exercise.SpringBoot.Exercise.Purchase.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.SpringBoot.Exercise.Customer.dao.ICustomerDAO;
import com.exercise.SpringBoot.Exercise.Product.dao.IProductDAO;
import com.exercise.SpringBoot.Exercise.Product.modelEntity.Product;
import com.exercise.SpringBoot.Exercise.Purchase.dao.IPurchaseDAO;
import com.exercise.SpringBoot.Exercise.Purchase.modelEntity.Purchase;

@Service
public class PurchaseService implements IPurchaseService {
    @Autowired
    private IPurchaseDAO purchaseDAO;

    @Autowired
    private ICustomerDAO customerDAO;

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Purchase> findAll() {
        return purchaseDAO.findAll();
    }

    @Override
    public Purchase save(Purchase purchase) {
        if(purchase.getCustomer() == null || customerDAO.findById(purchase.getCustomer().getId()).isEmpty())
            throw new RuntimeException("Customer not found");
        
        Product productToUpdate = productDAO.findById(purchase.getProduct().getId()).orElse(null);
        if(productToUpdate == null)
            throw new RuntimeException("Product not found");
        if(productToUpdate.getStock() < purchase.getQuantity())
            throw new RuntimeException("Not enough stock");
        productToUpdate.setStock(productToUpdate.getStock() - purchase.getQuantity());
        productDAO.save(productToUpdate);

        purchase.setDate(java.time.LocalDateTime.now().toString());
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
        return null;//purchaseDAO.getCustomerOrders(id);
    }
}
