package com.example.springapp.web.dao;

import com.example.springapp.web.model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Long> {
} 