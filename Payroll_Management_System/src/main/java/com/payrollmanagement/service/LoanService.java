package com.payrollmanagement.service;

import com.payrollmanagement.entity.Loanmaster;
import com.payrollmanagement.entity.Loantransaction;

public interface LoanService {
	
	Loanmaster saveDetails(Loanmaster master);
	
	Loantransaction save(Loantransaction loan);

}

