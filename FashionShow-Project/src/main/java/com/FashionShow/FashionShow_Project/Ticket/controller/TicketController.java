package com.FashionShow.FashionShow_Project.Ticket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FashionShow.FashionShow_Project.Ticket.modelEntity.Ticket;
import com.FashionShow.FashionShow_Project.Ticket.services.ITicketService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @GetMapping("/all")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Ticket ticket) {
        Map<String, String> response = new HashMap<>();
        try {
            ticketService.save(ticket);
            response.put("message", "Ticket saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(ticket);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Ticket Ticket = ticketService.findById(id);
        if (Ticket == null) {
            response.put("message", "Ticket not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(Ticket);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            ticketService.delete(id);
            response.put("message", "Ticket deleted successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }
}
