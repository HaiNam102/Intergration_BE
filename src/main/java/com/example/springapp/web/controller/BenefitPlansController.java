package com.example.springapp.web.controller;

import com.example.springapp.web.dao.BenefitPlansRepository;
import com.example.springapp.web.model.BenefitPlans;
import com.example.springapp.web.model.JobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/benefit-plans")
public class BenefitPlansController {

    @Autowired
    private BenefitPlansRepository benefitPlansRepository;

    // GET: api/benefit-plans
    @GetMapping
    public ResponseEntity<List<BenefitPlans>> getAllBenefitPlans() {
        List<BenefitPlans> benefitPlans = benefitPlansRepository.findAll();
        return new ResponseEntity<>(benefitPlans, HttpStatus.OK);
    }

    // GET: api/benefit-plans/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BenefitPlans> getBenefitPlanById(@PathVariable Long id) {
        Optional<BenefitPlans> benefitPlan = benefitPlansRepository.findById(id);
        if (benefitPlan.isPresent()) {
            return new ResponseEntity<>(benefitPlan.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<BenefitPlans>> getJobHistoryByEmployeeId(@PathVariable Long employeeId) {
        List<BenefitPlans> benefitPlans = benefitPlansRepository.findByEmployeeId(employeeId);
        return new ResponseEntity<>(benefitPlans, HttpStatus.OK);
    }

    // POST: api/benefit-plans
    @PostMapping
    public ResponseEntity<BenefitPlans> createBenefitPlan(@RequestBody BenefitPlans benefitPlan) {
        try {
            BenefitPlans savedBenefitPlan = benefitPlansRepository.save(benefitPlan);
            return new ResponseEntity<>(savedBenefitPlan, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT: api/benefit-plans/{id}
    @PutMapping("/{id}")
    public ResponseEntity<BenefitPlans> updateBenefitPlan(@PathVariable Long id, @RequestBody BenefitPlans benefitPlan) {
        Optional<BenefitPlans> existingBenefitPlan = benefitPlansRepository.findById(id);
        if (existingBenefitPlan.isPresent()) {
            benefitPlan.setBenefitPlanId(id);
            BenefitPlans updatedBenefitPlan = benefitPlansRepository.save(benefitPlan);
            return new ResponseEntity<>(updatedBenefitPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: api/benefit-plans/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBenefitPlan(@PathVariable Long id) {
        Optional<BenefitPlans> benefitPlan = benefitPlansRepository.findById(id);
        if (benefitPlan.isPresent()) {
            benefitPlansRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 