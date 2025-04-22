package com.example.springapp.web.dao;

import com.example.springapp.web.model.EmergencyContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface EmergencyContactsRepository extends JpaRepository<EmergencyContacts, Long> {
} 