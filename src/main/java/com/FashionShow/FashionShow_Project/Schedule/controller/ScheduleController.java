package com.FashionShow.FashionShow_Project.Schedule.controller;

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

import com.FashionShow.FashionShow_Project.Schedule.modelEntity.Schedule;
import com.FashionShow.FashionShow_Project.Schedule.services.IScheduleService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/all")
    public List<Schedule> findAll() {
        return scheduleService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Schedule schedule) {
        Map<String, String> response = new HashMap<>();
        try {
            scheduleService.save(schedule);
            response.put("message", "Schedule saved successfully");
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(schedule);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(Long id) {
        Map<String, String> response = new HashMap<>();
        Schedule schedule = scheduleService.findById(id);
        if (schedule == null) {
            response.put("message", "Schedule not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(schedule);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            scheduleService.delete(id);
            response.put("message", "Schedule deleted successfully");
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
