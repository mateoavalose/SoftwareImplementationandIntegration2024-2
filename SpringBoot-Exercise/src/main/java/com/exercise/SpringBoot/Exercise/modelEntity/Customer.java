package com.exercise.SpringBoot.Exercise.modelEntity;

import java.util.List;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "customers")
public class Customer implements Serializable{
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
    private String address;

    @Column
    @Getter()
    @Setter()
    @Email()
    private String email;

    @Column
    @Getter()
    @Setter()
    @Min(6)
    private Integer phone;

    @Column
    @Getter()
    @Setter()
    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchase;
}
