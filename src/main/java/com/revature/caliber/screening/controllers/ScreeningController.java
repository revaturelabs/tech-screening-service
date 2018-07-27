package com.revature.caliber.screening.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.beans.ViolationType;
import com.revature.caliber.screening.services.ScreeningService;
import com.revature.caliber.screening.services.SoftSkillViolationService;
import com.revature.caliber.screening.services.ViolationTypeService;
import com.revature.caliber.screening.wrappers.ViolationFlagWrapper;

@RestController
@CrossOrigin
public class ScreeningController {
	
	@Autowired
	ScreeningService screeningService;
	
	@Autowired
	SoftSkillViolationService softSkillViolationService;
	
	@Autowired
	ViolationTypeService violationTypeService;
	
	/**
	 * Returns a list of softSkillViolation objects by ScreeningID
	 * 
	 * @param screeningID - the unique id of a Screening
	 * @return List of SoftSkillViolation objects
	 */
	@RequestMapping(value="/screening/violation/{screeningID}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>>  softSkillViolationsByScreeningID(@PathVariable(value="screeningID") Integer screeningID){
		List<SoftSkillViolation> ssv = softSkillViolationService.getAllByScreeningId(screeningID);
		
		return new ResponseEntity<>(ssv, HttpStatus.OK);
	}
	
	/**
	 * Returns a list of ViolationType objects representing all held in the database
	 * 
	 * @return List of ViolationType objects
	 */
	@RequestMapping(value="/violation/all", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ViolationType>>getViolationTypes(){
		List<ViolationType> vios = violationTypeService.getAll();
		return new ResponseEntity<>(vios, HttpStatus.OK);
	}
	
	/**
	 * Delete a soft skill violation by its unique id
	 * 
	 * @param softSkillViolationID - the unique id of the SoftSkillViolation object to be deleted
	 * @return A ResponseEntity that contains a delete completed message and an HttpStatus of OK.
	 */
	@RequestMapping(value="/violation/delete/{softSkillViolationID}", method= RequestMethod.GET)
	public ResponseEntity<String> deleteSoftSkillViolation (@PathVariable(value="softSkillViolationID") Integer softSkillViolationID) {
		softSkillViolationService.delete(softSkillViolationID);
		return new ResponseEntity<>("Delete Completed", HttpStatus.OK);
	}
	
	/**
	 * Create a SoftSkillViolation for each ViolationID in the RequestBody, and associates it with the given Screening
	 * 
	 * @param violationFlag - a ViolationFlagWrapper that contains an array of ViolationIds, comment, time of violation, and screeningId
	 * @return An HttpStatus of OK signaling the successful entry of SoftSkillViolation objects.
	 */
	@RequestMapping(value = "/violation/flag", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSoftSkillViolationAndReturnSoftSkillViolationID (@RequestBody ViolationFlagWrapper violationFlag) {
		Screening screening = screeningService.getScreening(violationFlag.screeningId);
		for(Integer violationId : violationFlag.violationTypeId) {
			ViolationType vt = violationTypeService.getViolationType(violationId);
			SoftSkillViolation ssv = new SoftSkillViolation(screening, vt, violationFlag.softSkillComment, violationFlag.violationTime);
			softSkillViolationService.save(ssv);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
