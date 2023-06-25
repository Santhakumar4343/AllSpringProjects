package com.payrollmanagement.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.payrollmanagement.entity.Interviewer;
import com.payrollmanagement.serviceImpl.InterviewerServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InterviewerController {
    
    @Autowired
    private InterviewerServiceImpl interviewerService;

    @GetMapping("/interviewer")
    public List<Interviewer> getAllInterviewers(){
        return interviewerService.getAllInterviewers();
    }

    @PostMapping("/")
    public Interviewer createInterview( 
    		 @RequestParam String candidateid,
    		 @RequestParam String candidatename,
    		 @RequestParam String interviewername,
    		 @RequestParam Date date,
             @RequestParam String employeeId) {
    	
    	Interviewer interviewer= new Interviewer ();
        interviewer.setCandidateid(candidateid);
    	interviewer.setCandidatename(candidatename);
    	interviewer.setInterviewername(interviewername);
    	interviewer.setDate(date);
    	 
      return interviewerService.createInterviewer(interviewer, employeeId);
    }
 }