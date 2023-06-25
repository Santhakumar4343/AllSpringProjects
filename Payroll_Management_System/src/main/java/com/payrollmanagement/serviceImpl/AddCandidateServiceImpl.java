package com.payrollmanagement.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.payrollmanagement.entity.AddCandidate;
import com.payrollmanagement.repository.AddCandidateRepo;
import com.payrollmanagement.service.AddCandidateService;

@Service
public class AddCandidateServiceImpl implements AddCandidateService {

    @Autowired
    private AddCandidateRepo candidaterepo;

    private static int n = 001;

    @Override
    public List<AddCandidate> getAllCandidates() {
        return candidaterepo.findAll();
    }

    @Override
    public AddCandidate saveCandidate(AddCandidate candidate, MultipartFile file) throws IOException {
        String[] names = candidate.getFirstName().split(" ");
        String surname = names[names.length - 1].toUpperCase();

        String candidateId = String.format("%s%03d", surname.substring(0, 3), n);
        n++;
        candidate.setCandidateId(candidateId);

        if (!file.isEmpty()) {
            candidate.setResumeFile(file.getBytes());
        }

        return candidaterepo.save(candidate);
    }

    @Override
    public AddCandidate getCandidateById(String candidateId) {
        return candidaterepo.findById(candidateId).orElseThrow();
    }
}

