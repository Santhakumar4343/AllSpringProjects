package com.payrollmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payrollmanagement.entity.CandidateSelection;


public interface  CandidateSelectionRepository  extends JpaRepository<CandidateSelection, Long> {
}