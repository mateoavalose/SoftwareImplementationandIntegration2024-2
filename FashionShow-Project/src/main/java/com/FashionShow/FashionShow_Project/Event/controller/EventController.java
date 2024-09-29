package com.FashionShow.FashionShow_Project.Event.controller;

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

import com.FashionShow.FashionShow_Project.Event.modelEntity.Event;
import com.FashionShow.FashionShow_Project.Event.services.IEventService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/events")
public class EventController {
    @Autowired
    private IEventService eventService;

    @GetMapping("/all")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Event event) {
        Map<String, String> response = new HashMap<>();
        try {
            eventService.save(event);
            response.put("message", "Event saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(event);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Event Event = eventService.findById(id);
        if (Event == null) {
            response.put("message", "Event not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(Event);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            eventService.delete(id);
            response.put("message", "Event deleted successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }
}
