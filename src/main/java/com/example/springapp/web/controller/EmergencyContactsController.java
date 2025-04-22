package com.example.springapp.web.controller;

import com.example.springapp.web.dao.EmergencyContactsRepository;
import com.example.springapp.web.model.EmergencyContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emergency-contacts")
public class EmergencyContactsController {

    @Autowired
    private EmergencyContactsRepository emergencyContactsRepository;

    // GET: api/emergency-contacts
    @GetMapping
    public ResponseEntity<List<EmergencyContacts>> getAllEmergencyContacts() {
        List<EmergencyContacts> emergencyContacts = emergencyContactsRepository.findAll();
        return new ResponseEntity<>(emergencyContacts, HttpStatus.OK);
    }

    // GET: api/emergency-contacts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<EmergencyContacts> getEmergencyContactsById(@PathVariable Long id) {
        Optional<EmergencyContacts> emergencyContacts = emergencyContactsRepository.findById(id);
        if (emergencyContacts.isPresent()) {
            return new ResponseEntity<>(emergencyContacts.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: api/emergency-contacts
    @PostMapping
    public ResponseEntity<EmergencyContacts> createEmergencyContacts(@RequestBody EmergencyContacts emergencyContacts) {
        try {
            EmergencyContacts savedContacts = emergencyContactsRepository.save(emergencyContacts);
            return new ResponseEntity<>(savedContacts, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT: api/emergency-contacts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EmergencyContacts> updateEmergencyContacts(@PathVariable Long id, @RequestBody EmergencyContacts emergencyContacts) {
        Optional<EmergencyContacts> existingContacts = emergencyContactsRepository.findById(id);
        if (existingContacts.isPresent()) {
            emergencyContacts.setEmployeeId(id);
            EmergencyContacts updatedContacts = emergencyContactsRepository.save(emergencyContacts);
            return new ResponseEntity<>(updatedContacts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: api/emergency-contacts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencyContacts(@PathVariable Long id) {
        Optional<EmergencyContacts> emergencyContacts = emergencyContactsRepository.findById(id);
        if (emergencyContacts.isPresent()) {
            emergencyContactsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 