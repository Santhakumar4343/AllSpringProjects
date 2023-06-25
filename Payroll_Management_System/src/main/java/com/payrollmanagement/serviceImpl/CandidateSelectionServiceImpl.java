package com.payrollmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.CandidateSelection;
import com.payrollmanagement.repository.CandidateSelectionRepository;
import com.payrollmanagement.service.CandidateSelectionService;

@Service
public class CandidateSelectionServiceImpl implements CandidateSelectionService {

	@Autowired
	private CandidateSelectionRepository candidateSelectionRepository;

	public List<CandidateSelection> getAllCandidates() {
		return candidateSelectionRepository.findAll();
	}

	public CandidateSelection getCandidateById(Long candidateId) {
		Optional<CandidateSelection> optionalCandidate = candidateSelectionRepository.findById(candidateId);
		return optionalCandidate.orElse(null);
	}

	public CandidateSelection createCandidate(CandidateSelection candidate) {
		return candidateSelectionRepository.save(candidate);
	}

	// Update round two details based on round one status and remarks
	public CandidateSelection updateCandidateRoundTwo(Long interviewProcessId, String roundTwoStatus,
			String roundtwoRemarks) {
		CandidateSelection candidate = candidateSelectionRepository.findById(interviewProcessId).get();
		// Here checking round one status and remarks to insert data in Second round if
		// it is null can can't be insert
		if(candidate.getRoundOneStatus()!=null &&
				 candidate.getRoundoneRemarks()!=null) {
		candidate.setRoundTwoStatus(roundTwoStatus);
		candidate.setRoundtwoRemarks(roundtwoRemarks);
		}
		return candidateSelectionRepository.save(candidate);		
	}

	
	// Update round THREE details based on round two status and remarks
	public CandidateSelection updateCandidateRoundThree(Long interviewProcessId,
			 String roundThreeStatus, String roundthreeRemarks) {
		// Update round three details based on round two status and remarks
		CandidateSelection optionalCandidate = candidateSelectionRepository.findById(interviewProcessId).get();
		// Here checking round two status and remarks to insert data in Third round if
		// it is null can can't be insert
		 if(optionalCandidate.getRoundTwoStatus()!=null &&
		 optionalCandidate.getRoundtwoRemarks()!=null) {
		optionalCandidate.setRoundThreeStatus(roundThreeStatus);
		optionalCandidate.setRoundthreeRemarks(roundthreeRemarks);

		 }
		return candidateSelectionRepository.save(optionalCandidate);

		
	}
	
	

	public boolean deleteCandidate(Long candidateId) {
		Optional<CandidateSelection> optionalCandidate = candidateSelectionRepository.findById(candidateId);
		if (optionalCandidate.isPresent()) {
			candidateSelectionRepository.delete(optionalCandidate.get());
			return true;
		} else {
			return false;
		}
	}
}