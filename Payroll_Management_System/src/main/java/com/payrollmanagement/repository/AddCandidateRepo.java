package com.payrollmanagement.repository;


import com.payrollmanagement.entity.AddCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddCandidateRepo extends JpaRepository<AddCandidate, String> {
}
