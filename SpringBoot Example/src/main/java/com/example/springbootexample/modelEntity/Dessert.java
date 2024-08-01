package com.example.springbootexample.modelEntity;

import jakarta.persistence.GenerationType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name="desserts")

public class Dessert implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter()
    @Setter()
    private long id;

    @Column()
    @Getter()
    @Setter()
    private double price;

    @Column()
    @Getter()
    @Setter()
    private String name;

    @Column(name="description")
    @Getter()
    @Setter()
    private String desc;
}