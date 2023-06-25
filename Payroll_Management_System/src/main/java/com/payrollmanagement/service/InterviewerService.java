package com.payrollmanagement.service;
import java.util.List;

import com.payrollmanagement.entity.Interviewer;

public interface InterviewerService {
    public List<Interviewer> getAllInterviewers();
    public Interviewer createInterviewer(Interviewer interviewer, String employeeId);    
    }
