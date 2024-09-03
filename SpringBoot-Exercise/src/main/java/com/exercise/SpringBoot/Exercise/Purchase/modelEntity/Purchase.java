package com.exercise.SpringBoot.Exercise.Purchase.modelEntity;

import java.io.Serializable;
import com.exercise.SpringBoot.Exercise.Customer.modelEntity.Customer;
import com.exercise.SpringBoot.Exercise.Product.modelEntity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity()
public class Purchase implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Getter()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter()
    @Setter()
    // Date validation
    private String date;

    @Getter()
    @Setter()
    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Getter()
    @Setter()
    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column
    @Getter()
    @Setter()
    @Min(1)
    private int quantity;
}
