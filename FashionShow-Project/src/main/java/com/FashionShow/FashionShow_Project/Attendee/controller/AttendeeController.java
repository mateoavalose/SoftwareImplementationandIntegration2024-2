package com.FashionShow.FashionShow_Project.Attendee.controller;

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

import com.FashionShow.FashionShow_Project.Attendee.modelEntity.Attendee;
import com.FashionShow.FashionShow_Project.Attendee.services.IAttendeeService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/attendee")
public class AttendeeController {
    @Autowired
    private IAttendeeService attendeeService;

    @GetMapping("/all")
    public List<Attendee> findAll() {
        return attendeeService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Attendee attendee) {
        Map<String, String> response = new HashMap<>();
        try {
            attendeeService.save(attendee);
            response.put("message", "Attendee saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(attendee);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Attendee attendee = attendeeService.findById(id);
        if (attendee == null) {
            response.put("message", "Attendee not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(attendee);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            attendeeService.delete(id);
            response.put("message", "Attendee deleted successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }
}
