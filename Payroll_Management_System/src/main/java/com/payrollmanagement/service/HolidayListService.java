package com.payrollmanagement.service;


import java.util.List;

import com.payrollmanagement.entity.HolidayList;

public interface HolidayListService {
	
	HolidayList save(HolidayList holidayList);

	List<HolidayList> findAllHolidayLists();

}


