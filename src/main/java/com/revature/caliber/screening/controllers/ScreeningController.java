package com.revature.caliber.screening.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.screening.data.ScheduledScreeningRepository;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.data.SoftSkillViolationRepository;
import com.revature.caliber.screening.data.ViolationTypeRepository;

@RestController
@CrossOrigin
public class ScreeningController {
	
	@Autowired
	private ScreeningRepository screeningRepository;
	
	@Autowired
	private SoftSkillViolationRepository softSkillViolationRepository;

	@Autowired
	private ScheduledScreeningRepository scheduledScreeningRepository;
	
	@Autowired
	private ViolationTypeRepository violationTypeRepository;

	/**
	 * Get screenings based on the status provided.
	 * 
	 * @param status - A string notifying whether the screening is pending or complete.
	 * @return - List of SimpleScreening objects corresponding to status.
	 */
	@RequestMapping(value="/screening/scheduledScreenings", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduledScreening>> getAllScheduledScreenings(){
		List<ScheduledScreening> scheduledScreenings = scheduledScreeningRepository.findByStatus("PENDING");
		
		return new ResponseEntity<>(scheduledScreenings, HttpStatus.OK);
	}
}
