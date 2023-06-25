package com.payrollmanagement.controller;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payrollmanagement.entity.CandidateSelection;
import com.payrollmanagement.serviceImpl.CandidateSelectionServiceImpl;

@RestController
@RequestMapping("/candidates")
public class CandidateSelectionController {

	@Autowired
	private CandidateSelectionServiceImpl candidateSelectionServiceImpl;

	@GetMapping
	public List<CandidateSelection> getAllCandidates() {
		return candidateSelectionServiceImpl.getAllCandidates();
	}

	@GetMapping("/{candidateId}")
	public ResponseEntity<CandidateSelection> getCandidateById(@PathVariable Long candidateId) {
		CandidateSelection candidate = candidateSelectionServiceImpl.getCandidateById(candidateId);
		if (candidate != null) {
			return ResponseEntity.ok(candidate);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<CandidateSelection> createCandidate(
			@RequestParam(name = "candidateId", required = false) String candidateId,
			@RequestParam(name = "candidateName", required = false) String candidateName,
			@RequestParam(name = "interviewerId", required = false) String interviewerId,
			@RequestParam(name = "interviewerName", required = false) String interviewerName,
			@RequestParam(name = "dateOfInterview", required = false) Date dateOfInterview,
			@RequestParam(name = "roundOneStatus", required = false) String roundOneStatus,
			@RequestParam(name = "roundTwoStatus", required = false) String roundTwoStatus,
			@RequestParam(name = "roundThreeStatus", required = false) String roundThreeStatus,
			@RequestParam(name = "roundoneRemarks", required = false) String roundoneRemarks,
			@RequestParam(name = "roundtwoRemarks", required = false) String roundtwoRemarks,
			@RequestParam(name = "roundthreeRemarks", required = false) String roundthreeRemarks) {
		CandidateSelection createCandidate = new CandidateSelection();
		createCandidate.setCandidateId(candidateId);
		createCandidate.setCandidateName(candidateName);
		createCandidate.setInterviewerId(interviewerId);
		createCandidate.setInterviewerName(interviewerName);
		createCandidate.setDateOfInterview(dateOfInterview);
		createCandidate.setRoundOneStatus(roundOneStatus);
		createCandidate.setRoundoneRemarks(roundoneRemarks);
		createCandidate.setRoundTwoStatus(roundTwoStatus);
		createCandidate.setRoundtwoRemarks(roundtwoRemarks);
		createCandidate.setRoundThreeStatus(roundThreeStatus);
		createCandidate.setRoundthreeRemarks(roundthreeRemarks);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(candidateSelectionServiceImpl.createCandidate(createCandidate));
	}

	@PutMapping("/roundtwo/{interviewProcessId}")
	public ResponseEntity<CandidateSelection> updateCandidateRoundTwo(@PathVariable Long interviewProcessId,
			@RequestParam(name = "roundTwoStatus", required = false) String roundTwoStatus,
			@RequestParam(name = "roundtwoRemarks", required = false) String roundtwoRemarks) {
		return ResponseEntity.status(HttpStatus.CREATED).body(candidateSelectionServiceImpl
				.updateCandidateRoundTwo(interviewProcessId, roundTwoStatus, roundtwoRemarks));
		}

	@PutMapping("/roundthree/{interviewProcessId}")
	public ResponseEntity<CandidateSelection> updateCandidateRoundThree(@PathVariable Long interviewProcessId,
			@RequestParam(name = "roundThreeStatus", required = false) String roundThreeStatus,
			@RequestParam(name = "roundthreeRemarks", required = false) String roundthreeRemarks) {
		return ResponseEntity.status(HttpStatus.CREATED).body(candidateSelectionServiceImpl
				.updateCandidateRoundThree(interviewProcessId, roundThreeStatus, roundthreeRemarks));	
	}

	@DeleteMapping("/{candidateId}")
	public ResponseEntity<Void> deleteCandidate(@PathVariable Long candidateId) {
		boolean deleted = candidateSelectionServiceImpl.deleteCandidate(candidateId);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}