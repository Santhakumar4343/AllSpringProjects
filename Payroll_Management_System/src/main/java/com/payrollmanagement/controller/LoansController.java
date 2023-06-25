package com.payrollmanagement.controller;




import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payrollmanagement.entity.Loanmaster;
import com.payrollmanagement.entity.Loantransaction;
import com.payrollmanagement.repository.LoanmasterRepo;
import com.payrollmanagement.repository.LoantransactionRepo;
import com.payrollmanagement.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoansController {

	@Autowired
	private LoanmasterRepo masterrepo;

	@Autowired
	private LoantransactionRepo Transactionrepos;

	@Autowired
	private LoanService loanservice;

	private int sequenceNumber = 001; // initialize n to 1 This is for 3 Method running process

	// 1 method
	// This is to store values into Loan master table

	@PostMapping("/s")
	public Loanmaster method2(Loanmaster l, @RequestParam int tenure, @RequestParam long loan_SantionedAmount,
			@RequestParam long EMI, @RequestParam String loan_Transaction_id, @RequestParam String loan_Source_Bank,
			@RequestParam String loan_Credited_By, @RequestParam Date approved_date) {

		String prefix = "LN" + new SimpleDateFormat("yy").format(approved_date);

		// Generate the loan ID suffix using the current sequence number
		String suffix = String.format("%03d", sequenceNumber);

		// Combine the loan ID prefix and suffix to create the loan ID
		String loanID = prefix + suffix;

		l.setLoan_Santioned_id(loanID);
		sequenceNumber++;

		return loanservice.saveDetails(l);
	}
	
	

	// 2nd method This METHOD IS ONLY FOR GET ID IN POSTMAN
	
	

	@GetMapping("/get/{loan_Santionedid}")
	public ResponseEntity<Loanmaster> getLoanById(@PathVariable("loan_Santionedid") String loan_Santionedid) {
		Loanmaster loan = masterrepo.findById(loan_Santionedid).orElse(null);
		if (loan == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(loan);
		}
	}
	
	
	

	// 3rd method use to calucate emi as per Date and store in Loan transaction
	

	@PostMapping("/calculate-emi")
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Loantransaction calculateEMI(Loantransaction loan, Loanmaster master,
			@RequestParam("SalaryCreditedDate") java.sql.Date SalaryCreditedDate) {
		// Get loan information from the model attributes
		long amount = master.getLoan_SantionedAmount();
		int tenure = master.getTenure();
		long emi = master.getEMI();

		LocalDate approvalDate = master.getApproved_date().toLocalDate();
		LocalDate salaryCreditLocalDate = SalaryCreditedDate.toLocalDate();

		// Calculate number of EMIs already paid
		long emisPaid = ChronoUnit.MONTHS.between(approvalDate, salaryCreditLocalDate);

		// Calculate remaining months and balance
		int remainingMonths = tenure - (int) emisPaid;
		long remainingBalance = amount - (emisPaid * emi);

		// Update loan object with remaining balance and tenure
		loan.setBalanceAmount(remainingBalance);

		loan.setTenureremaining(remainingMonths);

		// Save the loan transaction to the database
		// Transactionrepos.save(loan);

		return loanservice.save(loan);
	}

}

