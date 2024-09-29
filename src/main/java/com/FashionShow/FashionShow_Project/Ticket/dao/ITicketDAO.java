package com.FashionShow.FashionShow_Project.Ticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Ticket.modelEntity.Ticket;

public interface ITicketDAO extends JpaRepository<Ticket, Long> {
    
}
