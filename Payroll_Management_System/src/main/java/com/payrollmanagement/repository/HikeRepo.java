package com.payrollmanagement.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.payrollmanagement.entity.Hike;

@Repository
public interface HikeRepo extends JpaRepository<Hike, String> {


	
}
