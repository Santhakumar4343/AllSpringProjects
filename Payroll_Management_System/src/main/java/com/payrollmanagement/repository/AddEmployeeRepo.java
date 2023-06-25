package com.payrollmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payrollmanagement.entity.AddEmployee;


@Repository
public interface AddEmployeeRepo extends JpaRepository<AddEmployee, String>{

}