package com.payrollmanagement.service;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.payrollmanagement.entity.AddCandidate;

public interface AddCandidateService {

	public List<AddCandidate> getAllCandidates();

	public AddCandidate saveCandidate(AddCandidate candidate, MultipartFile file) throws IOException;

	public AddCandidate getCandidateById(String candidateId);

}
