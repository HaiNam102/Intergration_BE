package com.example.springapp.web.controller;

import com.example.springapp.web.dao.EmployeeRepository;
import com.example.springapp.web.model.Employee;
import com.example.springapp.web.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/admin") // đổi để rõ đây là API
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee/list")
    public ResponseEntity<?> listUsers(HttpServletRequest request) {
        Users user = (Users) request.getSession().getAttribute("LOGGEDIN_USER");

        if (user != null) {
            List<Employee> employees = employeeRepository.findAll();
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Bạn chưa đăng nhập");
        }
    }
}
