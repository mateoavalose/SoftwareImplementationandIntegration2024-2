package com.example.springbootexample.modelEntity;

import jakarta.persistence.GenerationType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity()
@Table(name = "desserts")
public class Dessert implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    @Getter()
    @Setter()
    @Min(1)
    private double price;

    @Column(unique = true, nullable = false)
    @Getter()
    @Setter()
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Column(name = "description")
    @Getter()
    @Setter()
    private String desc;
    
    @ManyToMany(mappedBy = "dess")
    private List<Chef> chef;
}