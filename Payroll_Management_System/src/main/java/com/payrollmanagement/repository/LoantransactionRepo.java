package com.payrollmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payrollmanagement.entity.Loantransaction;

@Repository
public interface LoantransactionRepo extends JpaRepository<Loantransaction, Integer> {

}

