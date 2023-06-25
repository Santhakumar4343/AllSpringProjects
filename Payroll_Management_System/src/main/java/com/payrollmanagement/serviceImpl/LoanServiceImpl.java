package com.payrollmanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payrollmanagement.entity.Loanmaster;
import com.payrollmanagement.entity.Loantransaction;
import com.payrollmanagement.repository.LoanmasterRepo;
import com.payrollmanagement.repository.LoantransactionRepo;
import com.payrollmanagement.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanmasterRepo masterepo;
	
	@Autowired
	private LoantransactionRepo transactionrepos;

	@Override
	public Loanmaster saveDetails(Loanmaster master) {
		return masterepo.save(master);
	}

	@Override
	public Loantransaction save(Loantransaction loan) {
		return transactionrepos.save(loan);
	}
}
