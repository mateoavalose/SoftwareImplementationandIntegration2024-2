package com.FashionShow.FashionShow_Project.Participant.controller;

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

import com.FashionShow.FashionShow_Project.Participant.modelEntity.Participant;
import com.FashionShow.FashionShow_Project.Participant.services.IParticipantService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/participants")
public class ParticipantController {
    @Autowired
    private IParticipantService participantService;

    @GetMapping("/all")
    public List<Participant> findAll() {
        return participantService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Participant participant) {
        Map<String, String> response = new HashMap<>();
        try {
            participantService.save(participant);
            response.put("message", "Participant saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(participant);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Participant Participant = participantService.findById(id);
        if (Participant == null) {
            response.put("message", "Participant not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(Participant);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            participantService.delete(id);
            response.put("message", "Participant deleted successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }
}
