package com.example.springapp.web.controller;

import com.example.springapp.web.dao.PayRateRepository;
import com.example.springapp.web.model.PayRates;
import com.example.springapp.web.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller for managing PayRate entities
 *
 * @author AnhDao (modified)
 */
@RestController
@RequestMapping(value = "/api/admin")
public class PayRateController {

    private final PayRateRepository payRateRepository;

    @Autowired
    public PayRateController(PayRateRepository payRateRepository) {
        this.payRateRepository = payRateRepository;
    }

    @GetMapping("/payrates/list")
    public ResponseEntity<List<PayRates>> listPayRates(HttpServletRequest request) {
        // Kiểm tra người dùng đăng nhập
        Users user = (Users) request.getSession().getAttribute("LOGGEDIN_USER");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            List<PayRates> payRates = payRateRepository.findAllDistinct();
            return ResponseEntity.ok(payRates);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/payrates/create")
    public ResponseEntity<Map<String, Object>> createPayRate(@RequestBody PayRates payRate, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Check if user is logged in
        Users user = (Users) request.getSession().getAttribute("LOGGEDIN_USER");

        if (user == null) {
            response.put("success", false);
            response.put("message", "User not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        try {
            // Save new pay rate
            PayRates savedPayRate = payRateRepository.save(payRate);
            
            response.put("success", true);
            response.put("message", "Pay rate created successfully");
            response.put("payRate", savedPayRate);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error creating pay rate: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}