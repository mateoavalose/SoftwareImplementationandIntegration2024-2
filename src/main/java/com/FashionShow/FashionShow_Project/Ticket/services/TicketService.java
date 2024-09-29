package com.FashionShow.FashionShow_Project.Ticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Ticket.dao.ITicketDAO;
import com.FashionShow.FashionShow_Project.Ticket.modelEntity.Ticket;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketDAO ticketDAO;

    @Override
    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    @Override
    public Ticket save(Ticket Ticket) {
        return ticketDAO.save(Ticket);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        ticketDAO.deleteById(id);
    }

}