package com.payrollmanagement.service;



import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.Hike;


@Service
public interface HikeServiceInter {

	
	public Hike saveHike(Hike h);


	public Optional<Hike> getEmppThroughHikeID(String hikeId);
	
}

