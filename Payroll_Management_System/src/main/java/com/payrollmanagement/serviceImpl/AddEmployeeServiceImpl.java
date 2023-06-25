package com.payrollmanagement.serviceImpl;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.payrollmanagement.entity.AddCandidate;
import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.repository.AddCandidateRepo;
import com.payrollmanagement.repository.AddEmployeeRepo;
import com.payrollmanagement.service.AddEmployeeService;

@Service
public class AddEmployeeServiceImpl implements AddEmployeeService {

	@Autowired
	private AddEmployeeRepo addEmployeeRepo;

	@Autowired
	private AddCandidateRepo candidateRepo;

	private static int n = 001;

	public AddCandidate addCandidate(AddCandidate candidate) {
		return candidateRepo.save(candidate);
	}
	@Override
	public AddEmployee saveEmployeeDetails(@Valid AddEmployee emp, String joiningDateString, MultipartFile offerLetter,
			MultipartFile joiningLetter, MultipartFile agreement, MultipartFile experienceLetter, MultipartFile photo,
			String accountHolderName, String accountNumber, String ifscCode, String branch, String bankName,
			String panCard, String bloodGroup, String nominee, String nomineeContact) throws IOException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Change format string here
		LocalDate date = LocalDate.parse(joiningDateString, formatter);

		int year = date.getYear() % 100; // Get the last two digits of the year
		int dayOfMonth = date.getDayOfMonth();

		String formattedSequenceNumber = String.format("%03d", n);

		// Combine the year, day of month, and formatted sequence number into the
		// desired format
		String output = String.format("%02d%02d%s", year, dayOfMonth, formattedSequenceNumber);

		emp.setEmpId(output);
		// Increment the sequence number and format it with leading zeros
		n++;
		
		
		
		
		emp.setAccountHolderName(accountHolderName);
		emp.setAccountNumber(accountNumber);
		emp.setBankName(bankName);
		emp.setBloodGroup(bloodGroup);

		emp.setBranch(branch);
		emp.setIfscCode(ifscCode);
		emp.setBankName(bankName);
		emp.setPanCard(panCard);
		emp.setNominee(nominee);
		emp.setNomineeContact(nomineeContact);

		java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		emp.setJoiningDate(sqlDate);
		emp.setExperienceLetter(experienceLetter.getBytes());
		emp.setAgreement(agreement.getBytes());
		emp.setJoiningLetter(joiningLetter.getBytes());
		emp.setPhoto(photo.getBytes());
		emp.setOfferLetter(offerLetter.getBytes());

		return addEmployeeRepo.save(emp);
	}

	public AddEmployee getEmployeeById(String empId) {
		return addEmployeeRepo.findById(empId).orElse(null);
	}

	public List<AddEmployee> getAllEmployees() {
		return addEmployeeRepo.findAll();
	}

	public AddEmployee updateEmployee(String empId, MultipartFile offerLetter, MultipartFile joiningLetter,
			MultipartFile agreement, MultipartFile experienceLetter, MultipartFile photo, String accountHolderName,
			String accountNumber, String ifscCode, String branch, String bankName, String panCard, String bloodGroup,
			String nominee, String nomineeContact, Date joiningDate, AddCandidate candidateId) throws IOException {
		AddEmployee emp = addEmployeeRepo.findById(empId).get();
		emp.setAccountHolderName(accountHolderName);
		emp.setAccountNumber(accountNumber);
		emp.setAgreement(agreement.getBytes());
		emp.setBankName(bankName);
		emp.setBloodGroup(bloodGroup);
		emp.setBranch(branch);
		emp.setExperienceLetter(experienceLetter.getBytes());
		emp.setIfscCode(ifscCode);
		emp.setPanCard(panCard);
		emp.setPhoto(photo.getBytes());
		emp.setNominee(nominee);
		emp.setNomineeContact(nomineeContact);
		emp.setOfferLetter(offerLetter.getBytes());
		emp.setJoiningDate(joiningDate);
		emp.setJoiningLetter(joiningLetter.getBytes());

		return addEmployeeRepo.save(emp);
	}	
}
