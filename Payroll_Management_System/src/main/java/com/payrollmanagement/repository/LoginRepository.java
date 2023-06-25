package com.payrollmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.payrollmanagement.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
  /*  @Query("SELECT m.emp_Id, m.email FROM login_Credentials m WHERE m.id = :id")
    Optional<Object[]> findById(@Param("id") int id);
    */

	 Login findByOfficialEmail(String officialEmail);
}
