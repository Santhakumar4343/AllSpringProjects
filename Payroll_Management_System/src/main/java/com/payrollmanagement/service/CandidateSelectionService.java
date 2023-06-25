package com.payrollmanagement.service;


import java.util.List;

import com.payrollmanagement.entity.CandidateSelection;



public interface CandidateSelectionService {

	    List<CandidateSelection> getAllCandidates();

	    CandidateSelection getCandidateById(Long candidateId);

	    CandidateSelection createCandidate(CandidateSelection candidate);

	    CandidateSelection updateCandidateRoundTwo(Long interviewProcessId, String roundTwoStatus,String roundtwoRemarks);
	    
	    CandidateSelection updateCandidateRoundThree(Long interviewProcessId,String roundThreeStatus,String roundthreeRemarks);

	    boolean deleteCandidate(Long candidateId);
	    
	    
	   
	    
	}