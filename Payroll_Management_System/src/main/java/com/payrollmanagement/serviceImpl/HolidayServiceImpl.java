package com.payrollmanagement.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.HolidayList;
import com.payrollmanagement.repository.HolidaysListRepository;
import com.payrollmanagement.service.HolidayListService;

@Service
public class HolidayServiceImpl implements HolidayListService {

	@Autowired
	private HolidaysListRepository festivalRepository;

	@Override
	public HolidayList save(HolidayList holidayList) {
		return festivalRepository.save(holidayList);
	}

	@Override
	public List<HolidayList> findAllHolidayLists() {
		return festivalRepository.findAll();
	}

}