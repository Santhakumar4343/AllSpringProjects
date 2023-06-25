package com.payrollmanagement.repository;





import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payrollmanagement.entity.Loanmaster;

@Repository
public interface LoanmasterRepo extends CrudRepository<Loanmaster, String> {
	
	
}
