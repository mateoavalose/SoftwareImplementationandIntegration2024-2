package com.FashionShow.FashionShow_Project.Ticket.modelEntity;

import com.FashionShow.FashionShow_Project.Attendee.modelEntity.Attendee;
import com.FashionShow.FashionShow_Project.Event.modelEntity.Event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity()
@Table(name = "tickets")
@Data()
public class Ticket {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "event_id", nullable = false, referencedColumnName="id")
    private Event event;

    @ManyToOne()
    @JoinColumn(name = "attendee_id", nullable = false, referencedColumnName="id")
    private Attendee attendee;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "purchase_date", nullable = false)
    private String purchaseDate;
}
