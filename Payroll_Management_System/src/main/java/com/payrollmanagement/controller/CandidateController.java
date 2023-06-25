package com.payrollmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payrollmanagement.entity.AddCandidate;
import com.payrollmanagement.repository.AddCandidateRepo;
import com.payrollmanagement.service.AddCandidateService;
import com.payrollmanagement.serviceImpl.AddCandidateServiceImpl;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private AddCandidateServiceImpl candidateService;

    // get all candidates
    @RequestMapping("/home23")
    public String  getHome() {
        return "index";
    }

    // get all candidates
    @GetMapping("/candidates")
    public List<AddCandidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    // create candidate rest api
    @PostMapping("/candidates")
    public AddCandidate saveCandidate(@Valid @ModelAttribute AddCandidate candidate, BindingResult result, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            // Handle validation errors and return an error response
        }

        return candidateService.saveCandidate(candidate, file);
    }

    // get candidate by id rest api
    @GetMapping("/candidates/{candidateId}")
    public ResponseEntity<AddCandidate> getCandidateById(@PathVariable String candidateId) {
        AddCandidate candidate = candidateService.getCandidateById(candidateId);
        return ResponseEntity.ok(candidate);
    }
}
