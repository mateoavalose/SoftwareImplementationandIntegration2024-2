package com.example.springbootexample.modelEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;


@Entity
@Table(name="chefs")
@Data()
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @ManyToMany ()
    @JoinTable(
            name="chef_postre",
            joinColumns = @JoinColumn(name="chef_id"),
            inverseJoinColumns = @JoinColumn(name="dessert_id")
    )
    private List<Dessert> dess;
}