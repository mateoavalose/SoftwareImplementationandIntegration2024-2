package com.FashionShow.FashionShow_Project.Media.controller;

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

import com.FashionShow.FashionShow_Project.Media.modelEntity.Media;
import com.FashionShow.FashionShow_Project.Media.services.MediaService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @GetMapping("/all")
    public List<Media> findAll() {
        return mediaService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Media media) {
        Map<String, String> response = new HashMap<>();
        try {
            mediaService.save(media);
            response.put("message", "Media saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(media);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Media media = mediaService.findById(id);
        if (media == null) {
            response.put("message", "Media not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(media);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            mediaService.delete(id);
            response.put("message", "Media deleted successfully");
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
