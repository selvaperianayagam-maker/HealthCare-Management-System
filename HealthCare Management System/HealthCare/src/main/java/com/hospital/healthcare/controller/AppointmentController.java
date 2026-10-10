package com.hospital.healthcare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private List<Map<String, Object>> appointmentList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Map<String, Object>> scheduleAppointment(@RequestBody Map<String, Object> appointmentDetails) {
        appointmentList.add(appointmentDetails);
        return ResponseEntity.ok(appointmentDetails);
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllAppointments() {
        return ResponseEntity.ok(appointmentList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok("Appointment cancelled successfully with ID: " + id);
    }
}