package com.example.springapp.web.controller;

import com.example.springapp.web.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for dashboard functionality
 *
 * @author KunPC (modified)
 */
@RestController
@RequestMapping(value = "/api/admin")
public class SucccessController {

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Check if user is logged in
        Users user = (Users) request.getSession().getAttribute("LOGGEDIN_USER");

        if (user == null) {
            response.put("success", false);
            response.put("message", "User not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // Return dashboard data
        response.put("success", true);
        response.put("username", user.getUserName());

        // Add any dashboard-specific data here
        // For example:
        Map<String, Object> dashboardData = new HashMap<>();
        dashboardData.put("totalUsers", 120);
        dashboardData.put("activeUsers", 45);
        dashboardData.put("newUsers", 12);

        response.put("dashboardData", dashboardData);

        return ResponseEntity.ok(response);
    }
}