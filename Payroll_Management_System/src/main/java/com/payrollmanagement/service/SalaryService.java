package com.payrollmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.entity.Salary;


@Service
public interface SalaryService {

	public Salary saveEmpp(Salary e);
	public Salary getEmppThroughTransID( String empDummy);
	public List<Salary> getEmppThroughEmpID(AddEmployee empDummy);
	  public  String convertToIndianCurrency(double  finalSalary);
	
	
}
