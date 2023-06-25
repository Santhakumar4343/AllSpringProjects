package com.nsk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsk.entity.Employee;
import com.nsk.service.EmployeeService;

@RestController
public class EmployeeController {
	private EmployeeService service;

@PostMapping("/save")	
public String saveEMp(@RequestBody Employee emp) {
	Employee e=service.saveEmp(emp);
	String msg=null;
	if(e!=null) {
		msg="Registred Successfully";
	}
	else { 
	msg="Something went worng";}
	return msg;
}
}
