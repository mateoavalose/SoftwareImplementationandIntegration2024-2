package com.FashionShow.FashionShow_Project.Portfolio.modelEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity()
@Table(name = "portfolio")
@Data()
public class Portfolio {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participantID", updatable = false, nullable = false)
    private Long participantID;

    @Column(name = "media")
    private String[] media;

    @Column(name = "biography")
    private String biography;
}
