package com.example.springapp.web.dao;

import com.example.springapp.web.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
} 