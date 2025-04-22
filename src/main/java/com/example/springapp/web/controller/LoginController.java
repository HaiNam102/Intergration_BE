package com.example.springapp.web.controller;

import com.example.springapp.web.dao.UserRepository;
import com.example.springapp.web.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/admin")
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Users user, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Check login credentials using repository
        if (!userRepository.login(user.getUserName(), user.getPassword())) {
            response.put("success", false);
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            request.getSession().setAttribute("LOGGEDIN_USER", user);
            request.getSession().setAttribute("USER", user.getUserName());

            response.put("success", true);
            response.put("message", "Login successful");
            response.put("username", user.getUserName());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        request.getSession().removeAttribute("LOGGEDIN_USER");
        request.getSession().removeAttribute("USER");

        response.put("success", true);
        response.put("message", "Logout successful");
        return ResponseEntity.ok(response);
    }
}