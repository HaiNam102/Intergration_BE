package com.example.springapp.web.controller;

import com.example.springapp.web.dao.UserRepository;
import com.example.springapp.web.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller for User management
 *
 * @author KunPC (modified)
 */
@RestController
@RequestMapping(value = "/api/admin/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> listUsers(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Check if user is logged in
        Users user = (Users) request.getSession().getAttribute("LOGGEDIN_USER");

        if (user == null) {
            response.put("success", false);
            response.put("message", "User not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        try {
            // Get all users
            List<Users> users = userRepository.findAll();

            response.put("success", true);
            response.put("users", users);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error retrieving users: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody Users user, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Check if user is logged in
        Users loggedInUser = (Users) request.getSession().getAttribute("LOGGEDIN_USER");

        if (loggedInUser == null) {
            response.put("success", false);
            response.put("message", "User not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        try {
            // Check if username already exists
            if (userRepository.checkUserExists(user.getUserName())) {
                response.put("success", false);
                response.put("message", "Username already exists");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }

            // Save the new user
            Users savedUser = userRepository.save(user);

            response.put("success", true);
            response.put("message", "User added successfully");
            response.put("user", savedUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error adding user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/checkUsername")
    public ResponseEntity<Map<String, Object>> checkUsername(@RequestParam String username, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Check if user is logged in
        Users loggedInUser = (Users) request.getSession().getAttribute("LOGGEDIN_USER");

        if (loggedInUser == null) {
            response.put("success", false);
            response.put("message", "User not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        boolean exists = userRepository.checkUserExists(username);

        response.put("success", true);
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
}