package com.example.demo.controller;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@CrossOrigin(origins ="http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/add")
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping("/user/{email}")
    public List<Job> getJobsByUser(@PathVariable String email) {
        return jobRepository.findByUserEmail(email);
    }

    
    @DeleteMapping("/{id}")
public ResponseEntity<?> deleteJob(@PathVariable Long id) {
    try {
        jobRepository.deleteById(id);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
}