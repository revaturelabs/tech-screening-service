package com.revature.screenforce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.services.ScreeningReportService;

@RestController
@CrossOrigin
public class ScreeningReportsController {

	//variables
	@Autowired ScreeningReportService screeningReportService;
	
	//methods
	@GetMapping(value="/softskillviolations")
	public List<SoftSkillViolation> getAllSoftSkillViolations() {
		return this.screeningReportService.getAllSoftSkillViolations();
	}
}
