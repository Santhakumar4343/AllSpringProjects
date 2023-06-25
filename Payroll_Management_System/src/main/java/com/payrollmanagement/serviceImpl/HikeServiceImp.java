package com.payrollmanagement.serviceImpl;





import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.entity.Hike;
import com.payrollmanagement.repository.HikeRepo;
import com.payrollmanagement.service.HikeServiceInter;

@Service
public class HikeServiceImp implements HikeServiceInter {

	

	@Autowired
	private HikeRepo Hrepo;

	
	
	@Override
	public Hike saveHike(Hike h) {

		h.setFinal_salary((h.getConsolidated_sal()) + ((h.getHike_percentage() / 100) * (h.getConsolidated_sal())));

		  
	      LocalDate date = LocalDate.now();
	    int Year =  date.getYear();
	  
		   int LastTwo = Year%100;
	   
	    
	  AddEmployee EmpId_Which_is_given =  h.getEmpId();
	String String_EmpId_Which_is_given = EmpId_Which_is_given.getEmpId();
	 
	  

	    String Hike_Id_With_Serial = "HK" + LastTwo + String_EmpId_Which_is_given  ;
	    
	    
	h.setHikeId(Hike_Id_With_Serial);
		
		
		
		
		return Hrepo.save(h);

	}


	@Override
	public Optional<Hike> getEmppThroughHikeID(String hikeId) {
		
		return  Hrepo.findById(hikeId);
	}



	}
