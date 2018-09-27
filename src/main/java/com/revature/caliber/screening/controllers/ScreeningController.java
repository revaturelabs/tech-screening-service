package com.revature.caliber.screening.controllers;

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


/**
 * The controller for incoming REST requests to the Screening service.
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 * @author David Miller | 1805-WVU-MAY29 | Richard Orr
 */
@RestController
@CrossOrigin
public class ScreeningController {	
	@Autowired
	ScreeningService screeningService;
	
	@Autowired
	SoftSkillViolationService softSkillViolationService;
	
	@Autowired
	ViolationTypeService violationTypeService;
  
  	@Autowired
	private ScheduledScreeningRepository scheduledScreeningService;
	
	/**
	 * Get screenings based on the status provided.
	 * 
	 * @param status - A string notifying whether the screening is pending or complete.
	 * @return - List of SimpleScreening objects corresponding to status.
	 */
	@RequestMapping(value="/screening/scheduled", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduledScreening>> getAllScheduledScreenings(){
		List<ScheduledScreening> scheduledScreenings = scheduledScreeningService.findByStatus("PENDING");
		
		return new ResponseEntity<>(scheduledScreenings, HttpStatus.OK);
  }
	
	/**
	 * Returns a list of softSkillViolation objects by ScreeningID
	 * 
	 * @param screeningID - the unique id of a Screening
	 * @return List of SoftSkillViolation objects
	 */
	@RequestMapping(value="/screening/{id}/violation/", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>>  softSkillViolationByScreeningID(@PathVariable(value="id") Integer id){
		List<SoftSkillViolation> ssv = softSkillViolationService.getAllByScreeningId(id);

		return new ResponseEntity<>(ssv, HttpStatus.OK);
	}
	
	/**
	 * Returns a list of ViolationType objects representing all held in the database
	 * 
	 * @return List of ViolationType objects
	 */
	@RequestMapping(value="/violation/type", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ViolationType>> getViolationTypes(){
		List<ViolationType> vios = violationTypeService.getAll();
		return new ResponseEntity<>(vios, HttpStatus.OK);
	}
	
	/**
	 * Delete a soft skill violation by its unique id
	 * 
	 * @param softSkillViolationID - the unique id of the SoftSkillViolation object to be deleted
	 * @return A ResponseEntity that contains a delete completed message and an HttpStatus of OK.
	 */
	@RequestMapping(value="/violation/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteSoftSkillViolation (@PathVariable(value="id") Integer id) {
		try {
			softSkillViolationService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Delete Completed", HttpStatus.OK);
	}
	
	/**
	 * Create a SoftSkillViolation for each ViolationID in the RequestBody, and associates it with the given Screening
	 * 
	 * @param violationFlag - a ViolationFlagWrapper that contains a ViolationId, comment, time of violation, and screeningId
	 * @return An HttpStatus of OK signaling the successful entry of SoftSkillViolation objects.
	 */
	@RequestMapping(value = "/violation/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SoftSkillViolation> createSoftSkillViolationAndReturnSoftSkillViolationID (@RequestBody ViolationFlagWrapper violationFlag) {
		SoftSkillViolation ssv = new SoftSkillViolation(violationFlag.getScreeningId(), 
				violationFlag.getViolationTypeId(), 
				violationFlag.getSoftSkillComment(),
				violationFlag.getViolationTime());
		
		ssv = softSkillViolationService.save(ssv);
		return new ResponseEntity<>(ssv, HttpStatus.OK);
	}
}
