package com.nsk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsk.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
