package com.payrollmanagement.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.entity.Salary;



@Repository
public interface SalaryRepo extends JpaRepository<Salary,String>
{

	
	@Query(value="SELECT SUBSTR(transaction_id, 8, 10) AS result FROM Emp  order by transaction_id desc limit 1 ",nativeQuery = true)
	String lastValueCheck();
	
	
	List<Salary> findByAddEmployee(AddEmployee addEmployee);

	@Query("SELECT AC.candidateId FROM Salary E JOIN AddEmployee AE ON E.addEmployee = AE.empId JOIN AddCandidate AC ON AE.candidateId = AC.candidateId WHERE E.addEmployee = addEmployee")
    String findCandidateIdByEmpId(@Param("addEmployee") AddEmployee addEmployee);

	

	
}


