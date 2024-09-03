package com.exercise.SpringBoot.Exercise.Customer.modelEntity;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "customers")
public class Customer implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Getter()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter()
    @Setter()
    @Size(min = 3)
    private String name;

    @Column
    @Getter()
    @Setter()
    @Size(min = 3)
    private String address;

    @Column
    @Getter()
    @Setter()
    @Email()
    private String email;

    @Column
    @Getter()
    @Setter()
    @Size(min = 3)
    private Integer phone;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchase;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", purchase=" + purchase +
                '}';
    }
}
