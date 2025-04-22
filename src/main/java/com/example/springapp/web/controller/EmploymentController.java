package com.example.springapp.web.controller;

import com.example.springapp.web.dao.EmploymentRepository;
import com.example.springapp.web.model.Employment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employment")
public class EmploymentController {

    @Autowired
    private EmploymentRepository employmentRepository;

    // GET: api/employment
    @GetMapping
    public ResponseEntity<List<Employment>> getAllEmployment() {
        List<Employment> employments = employmentRepository.findAll();
        return new ResponseEntity<>(employments, HttpStatus.OK);
    }

    // GET: api/employment/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employment> getEmploymentById(@PathVariable Long id) {
        Optional<Employment> employment = employmentRepository.findById(id);
        if (employment.isPresent()) {
            return new ResponseEntity<>(employment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: api/employment
    @PostMapping
    public ResponseEntity<Employment> createEmployment(@RequestBody Employment employment) {
        try {
            Employment savedEmployment = employmentRepository.save(employment);
            return new ResponseEntity<>(savedEmployment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT: api/employment/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employment> updateEmployment(@PathVariable Long id, @RequestBody Employment employment) {
        Optional<Employment> existingEmployment = employmentRepository.findById(id);
        if (existingEmployment.isPresent()) {
            employment.setEmployeeId(id);
            Employment updatedEmployment = employmentRepository.save(employment);
            return new ResponseEntity<>(updatedEmployment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: api/employment/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployment(@PathVariable Long id) {
        Optional<Employment> employment = employmentRepository.findById(id);
        if (employment.isPresent()) {
            employmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 