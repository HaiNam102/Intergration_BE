package com.example.springapp.web.controller;

import com.example.springapp.web.dao.JobHistoryRepository;
import com.example.springapp.web.dao.PersonalRepository;
import com.example.springapp.web.model.JobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-history")
public class JobHistoryController {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @Autowired
    private PersonalRepository personalRepository;

    // GET: api/job-history
    @GetMapping
    public ResponseEntity<List<JobHistory>> getAllJobHistory() {
        List<JobHistory> jobHistories = jobHistoryRepository.findAll();
        return new ResponseEntity<>(jobHistories, HttpStatus.OK);
    }

    // GET: api/job-history/{id}
    @GetMapping("/{id}")
    public ResponseEntity<JobHistory> getJobHistoryById(@PathVariable Long id) {
        Optional<JobHistory> jobHistory = jobHistoryRepository.findById(id);
        if (jobHistory.isPresent()) {
            return new ResponseEntity<>(jobHistory.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET: api/job-history/employee/{employeeId}
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<JobHistory>> getJobHistoryByEmployeeId(@PathVariable Long employeeId) {
        List<JobHistory> jobHistories = jobHistoryRepository.findByEmployeeId(employeeId);
        return new ResponseEntity<>(jobHistories, HttpStatus.OK);
    }

    // POST: api/job-history
    @PostMapping
    public ResponseEntity<JobHistory> createJobHistory(@RequestBody JobHistory jobHistory) {
        try {
            JobHistory savedJobHistory = jobHistoryRepository.save(jobHistory);
            return new ResponseEntity<>(savedJobHistory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT: api/job-history/{id}
    @PutMapping("/{id}")
    public ResponseEntity<JobHistory> updateJobHistory(@PathVariable Long id, @RequestBody JobHistory jobHistory) {
        Optional<JobHistory> existingJobHistory = jobHistoryRepository.findById(id);
        if (existingJobHistory.isPresent()) {
            jobHistory.setId(id);
            JobHistory updatedJobHistory = jobHistoryRepository.save(jobHistory);
            return new ResponseEntity<>(updatedJobHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: api/job-history/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobHistory(@PathVariable Long id) {
        Optional<JobHistory> jobHistory = jobHistoryRepository.findById(id);
        if (jobHistory.isPresent()) {
            jobHistoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 