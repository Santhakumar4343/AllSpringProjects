package com.payrollmanagement.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payrollmanagement.entity.AddCandidate;
import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.serviceImpl.AddEmployeeServiceImpl;

@RestController
@RequestMapping("/home")
public class AddEmployeeController {

	    @Autowired
	    private AddEmployeeServiceImpl employeeService;
	    
//	    @Autowired
//	    private AddCandidateServiceImpl candidateService;
//
////	    @PostMapping(value = "/req1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
////	    public AddCandidate addCandidate(@ModelAttribute @Valid AddCandidate candidate, BindingResult bindingResult) {
////	        if (bindingResult.hasErrors()) {
////	            // handle validation errors
////	        }
////
////	        return employeeService.addCandidate(candidate);
////	    }


	    @PostMapping("/save")
	    public AddEmployee saveEmployeeDetails(@Valid @ModelAttribute("addEmployee") AddEmployee emp,
	                                BindingResult result, Model model,
	                                @RequestParam("joiningDateString") String joiningDateString,
	                                @RequestParam("offerLetter") MultipartFile offerLetter,
	                                @RequestParam("joiningLetter") MultipartFile joiningLetter,
	                                @RequestParam("agreement") MultipartFile agreement,
	                                @RequestParam("experienceLetter") MultipartFile experienceLetter,
	                                @RequestParam("photo") MultipartFile photo,
	                                @RequestParam("accountHolderName") String accountHolderName,
	                                @RequestParam("accountNumber") String accountNumber, 
	                                @RequestParam("ifscCode") String ifscCode,
	                                @RequestParam("branch") String branch,
	                                @RequestParam("bankName") String bankName,
	                                @RequestParam("panCard") String panCard,
	                                @RequestParam("bloodGroup") String bloodGroup, 
	                                @RequestParam("nominee") String nominee, 
	                                @RequestParam("nomineeContact") String nomineeContact
	                                )
	            throws IOException {
	    	java.sql.Date sqlDate = java.sql.Date.valueOf(joiningDateString);
	        emp.setJoiningDate(sqlDate);
	        emp.setExperienceLetter(experienceLetter.getBytes());
	        emp.setAgreement(agreement.getBytes());
	        emp.setJoiningLetter(joiningLetter.getBytes());
	        emp.setPhoto(photo.getBytes());
	        emp.setOfferLetter(offerLetter.getBytes());
	        emp.setAccountHolderName(accountHolderName);
	        emp.setAccountNumber(accountNumber);
	        emp.setBankName(bankName);
	        emp.setBloodGroup(bloodGroup);
	        emp.setBranch(branch);
	        emp.setIfscCode(ifscCode);
	        emp.setPanCard(panCard);
	        emp.setNominee(nominee);
	        emp.setNomineeContact(nomineeContact);

	        return employeeService.saveEmployeeDetails( emp, joiningDateString, offerLetter,
	    			joiningLetter, agreement, experienceLetter, photo,
	    			 accountHolderName, accountNumber, ifscCode, branch, bankName,
	    			 panCard,  bloodGroup, nominee,  nomineeContact);
	    }
	    
	    @GetMapping("/get/{empId}")
	    public AddEmployee getEmployee(@PathVariable String empId) {
	      return employeeService.getEmployeeById(empId);
	    }

	    @GetMapping("/getAll")
	    public List<AddEmployee> getAllEmployees() {
	      return employeeService.getAllEmployees();
	    }
	    
	        @PutMapping("/employees/{empId}")
	        public AddEmployee updateEmployee(@RequestParam("offerLetter") MultipartFile offerLetter,
	                                           @RequestParam("joiningLetter") MultipartFile joiningLetter,
	                                           @RequestParam("agreement") MultipartFile agreement,
	                                           @RequestParam("experienceLetter") MultipartFile experienceLetter,
	                                           @RequestParam("photo") MultipartFile photo,
	                                           @RequestParam("accountHolderName") String accountHolderName,
	                                           @RequestParam("accountNumber") String accountNumber,
	                                           @RequestParam("ifscCode") String ifscCode,
	                                           @RequestParam("branch") String branch,
	                                           @RequestParam("bankName") String bankName,
	                                           @RequestParam("panCard") String panCard,
	                                           @RequestParam("bloodGroup") String bloodGroup,
	                                           @RequestParam("nominee") String nominee,
	                                           @RequestParam("nomineeContact") String nomineeContact,
	                                           @RequestParam("joiningDate") Date joiningDate,
	                                           @RequestParam("candidateId") AddCandidate candidateId,
	                                           @PathVariable String empId) throws IOException {

	            AddEmployee updatedEmployee = employeeService.updateEmployee(empId, offerLetter, joiningLetter, agreement, experienceLetter,
	            		photo, accountHolderName, accountNumber, ifscCode, branch, bankName, panCard, bloodGroup, nominee, nomineeContact,
	            		joiningDate, candidateId);
	            return updatedEmployee;
	        }
	    }