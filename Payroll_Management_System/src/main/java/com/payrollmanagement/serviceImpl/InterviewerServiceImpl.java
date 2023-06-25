package com.payrollmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.Interviewer;
import com.payrollmanagement.repository.InterviewerRepository;
import com.payrollmanagement.service.InterviewerService;

@Service
public class InterviewerServiceImpl implements InterviewerService {
    
    @Autowired
    private InterviewerRepository interviewerRepository;

    @Override
    public List<Interviewer> getAllInterviewers() {
        return interviewerRepository.findAll();
    }

    @Override
    public Interviewer createInterviewer(Interviewer interviewer, String employeeId) {
        String stati = "INT";
        String formattedEmployeeId = String.format("%03d", Integer.parseInt(employeeId));
        String interviewerid = stati.concat(formattedEmployeeId);
        interviewer.setInterviewerid(interviewerid);
        return interviewerRepository.save(interviewer);
    }
}
