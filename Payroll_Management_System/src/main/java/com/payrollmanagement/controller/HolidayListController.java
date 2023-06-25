package com.payrollmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payrollmanagement.entity.HolidayList;
import com.payrollmanagement.serviceImpl.HolidayServiceImpl;

@RestController
@RequestMapping("/api")
public class HolidayListController {
	@Autowired
	private HolidayServiceImpl holidayServiceImpl;

	@PostMapping("/Festival")
	public HolidayList saveDetailss(@ModelAttribute HolidayList holidayList) {
		return holidayServiceImpl.save(holidayList);

	}

	@GetMapping("/data")
	public List<HolidayList> Data() {
		return holidayServiceImpl.findAllHolidayLists();
	}
}
