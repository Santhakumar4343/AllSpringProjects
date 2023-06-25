package com.payrollmanagement.controller;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payrollmanagement.entity.Hike;
import com.payrollmanagement.service.HikeServiceInter;

@RestController
@RequestMapping("/api") 
public class HikeController {

	
	@Autowired
	private HikeServiceInter serviceInter;
	
	@PostMapping("/SaveHike")
	
	public Hike saveDetails(@RequestBody Hike h) {
		
		return serviceInter.saveHike(h);
	}
	
	  @GetMapping("/getOne/{Hike_Id}")
	    public Optional<Hike> getEmployeeDetailsThroughTransID(@PathVariable("Hike_Id") String Hike_Id) {
	     	    	
	    	return	serviceInter.getEmppThroughHikeID(Hike_Id);
	        		    
	    }
	          
}