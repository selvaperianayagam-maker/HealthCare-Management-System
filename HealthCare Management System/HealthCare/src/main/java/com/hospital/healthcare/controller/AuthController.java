package com.hospital.healthcare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> registrationRequest) {
       
        String username = registrationRequest.get("username");
        return ResponseEntity.ok("User '" + username + "' registered successfully!");
    }
}