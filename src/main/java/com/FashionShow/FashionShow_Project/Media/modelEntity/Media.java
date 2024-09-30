package com.FashionShow.FashionShow_Project.Media.modelEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity()
@Table(name = "media")
@Data()
public class Media {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "uploadDate")
    private String uploadDate;

    @Column(name = "url")
    private String url;

    @Column(name = "event_id")
    private Long event_id;
}
