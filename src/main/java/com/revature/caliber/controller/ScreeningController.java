package com.revature.caliber.controller;

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
import com.revature.caliber.beans.ScheduledStatus;
import com.revature.caliber.beans.SimpleScheduledScreening;
import com.revature.caliber.beans.SimpleTrainee;
import com.revature.caliber.beans.Trainee;
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
	
	private ScreeningCompositionService scs;

	@Autowired
	public void setScreeningCompositionService(ScreeningCompositionService scs) {
		this.scs = scs;
	}
	/**
	 * Get screenings based on the status provided.
	 * 
	 * @param status - A string notifying whether the screening is pending or complete.
	 * @return - List of SimpleScreening objects corresponding to status.
	 */
	@RequestMapping(value="/screening/scheduledScreenings", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduledScreening>> getAllScheduledScreenings(){
		
		List<SimpleScheduledScreening> simpleScheduledScreenings = scheduledScreeningRepository.findByStatus("PENDING");

		List<ScheduledScreening> scheduledScreenings=new ArrayList<>();
		
		for(SimpleScheduledScreening screening : simpleScheduledScreenings) {
			Integer traineeId = screening.getTrainee();
			SimpleTrainee simpleTrainee = scs.getOneTrainee(traineeId);
			
			scheduledScreenings.add(new ScheduledScreening(
					new Trainee(simpleTrainee),
					0,
					ScheduledStatus.PENDING, 
					screening.getScheduledScreeningId(),
					screening.getSkillTypeId(),
					screening.getScheduledDate())
					);
		}
		
		return new ResponseEntity<>(scheduledScreenings, HttpStatus.OK);
	}
}
