package com.FashionShow.FashionShow_Project.Ticket.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Ticket.modelEntity.Ticket;

public interface ITicketService {
    public List<Ticket> findAll();

    public Ticket save(Ticket ticket);

    public Ticket findById(Long id);

    public void delete(Long id);
}
