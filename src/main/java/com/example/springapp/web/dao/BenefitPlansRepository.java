package com.example.springapp.web.dao;

import com.example.springapp.web.model.BenefitPlans;
import com.example.springapp.web.model.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BenefitPlansRepository extends JpaRepository<BenefitPlans, Long> {
    @Query("SELECT p.benefitPlans1 FROM Personal p WHERE p.employeeId = :employeeId")
    List<BenefitPlans> findByEmployeeId(Long employeeId);
} 