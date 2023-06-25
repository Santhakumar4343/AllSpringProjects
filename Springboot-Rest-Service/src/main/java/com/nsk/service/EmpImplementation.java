package com.nsk.service;

import java.util.List;

import com.nsk.entity.Employee;
import com.nsk.repo.EmployeeRepo;

public class EmpImplementation implements EmployeeService{
     private EmployeeRepo repo;
	@Override
	public Employee saveEmp(Employee emp) {
		Employee e=repo.save(emp);
		return e;
	}
	@Override
	public void deleteEmp(int empid) {
		repo.deleteById(empid);
	}
	@Override
	public Employee getEmp(int empid) {
		Employee e1=repo.findById(empid).get();
		return e1;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> l=repo.findAll();
		return l;
	}

	@Override
	public Employee updateEmp(Employee emp,int empid) {
		Employee emps=repo.findById(empid).get();
		emps.setEmail(emp.getEmail());
		emps.setDesg(emp.getDesg());
		emps.setPassword(emp.getPassword());
		return repo.save(emps);
	}

}
