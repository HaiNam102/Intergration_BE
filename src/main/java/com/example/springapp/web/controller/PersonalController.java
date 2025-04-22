package com.example.springapp.web.controller;

import com.example.springapp.web.dao.BenefitPlansRepository;
import com.example.springapp.web.dao.EmergencyContactsRepository;
import com.example.springapp.web.dao.EmploymentRepository;
import com.example.springapp.web.dao.PersonalRepository;
import com.example.springapp.web.model.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personals")
public class PersonalController {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private BenefitPlansRepository benefitPlansRepository;

    @Autowired
    private EmergencyContactsRepository emergencyContactsRepository;

    @Autowired
    private EmploymentRepository employmentRepository;

    // GET: api/personals
    @GetMapping
    public ResponseEntity<List<Personal>> getAllPersonals() {
        List<Personal> personals = personalRepository.findAll();
        return new ResponseEntity<>(personals, HttpStatus.OK);
    }

    // GET: api/personals/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id) {
        Optional<Personal> personal = personalRepository.findById(id);
        if (personal.isPresent()) {
            return new ResponseEntity<>(personal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: api/personals
    @PostMapping
    public ResponseEntity<Personal> createPersonal(@RequestBody Personal personal) {
        try {
            Personal savedPersonal = personalRepository.save(personal);
            return new ResponseEntity<>(savedPersonal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT: api/personals/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable Long id, @RequestBody Personal personal) {
        Optional<Personal> existingPersonal = personalRepository.findById(id);
        if (existingPersonal.isPresent()) {
            personal.setEmployeeId(id);
            Personal updatedPersonal = personalRepository.save(personal);
            return new ResponseEntity<>(updatedPersonal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: api/personals/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        Optional<Personal> personal = personalRepository.findById(id);
        if (personal.isPresent()) {
            personalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 