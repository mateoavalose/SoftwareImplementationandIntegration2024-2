package com.exercise.SpringBoot.Exercise.Product.modelEntity;

import java.util.List;
import com.exercise.SpringBoot.Exercise.Purchase.modelEntity.Purchase;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "products")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter()
    @Setter()
    @Min(3)
    private String name;

    @Column
    @Getter()
    @Setter()
    @Min(3)
    private String description;

    @Column
    @Getter()
    @Setter()
    @Min(1)
    private double price;

    @Column
    @Getter()
    @Setter()
    @Min(0)
    private int stock;

    @Column
    @Getter()
    @Setter()
    @OneToMany(mappedBy = "product")
    private List<Purchase> purchase;
}
