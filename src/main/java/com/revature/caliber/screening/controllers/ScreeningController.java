package com.revature.caliber.screening.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.beans.ViolationType;
import com.revature.caliber.screening.services.ScheduledScreeningService;
import com.revature.caliber.screening.services.ScreeningService;
import com.revature.caliber.screening.services.SoftSkillViolationService;
import com.revature.caliber.screening.services.ViolationTypeService;
import com.revature.caliber.screening.wrappers.CommentWrapper;
import com.revature.caliber.screening.wrappers.EndingWrapper;
import com.revature.caliber.screening.wrappers.StartingWrapper;
import com.revature.caliber.screening.wrappers.ViolationFlagWrapper;


@RestController
public class ScreeningController {
	
	@Autowired
	ScheduledScreeningService scheduledScreeningService;
	
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
	@RequestMapping(value="/screening/{id}/violation/", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SoftSkillViolation>  softSkillViolationByScreeningID(@PathVariable(value="id") Integer id){
		SoftSkillViolation ssv = softSkillViolationService.getByScreeningId(id);

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
		softSkillViolationService.delete(id);
		return new ResponseEntity<>("Delete Completed", HttpStatus.OK);
	}
	
	/**
	 * Create a SoftSkillViolation for each ViolationID in the RequestBody, and associates it with the given Screening
	 * 
	 * @param violationFlag - a ViolationFlagWrapper that contains a ViolationId, comment, time of violation, and screeningId
	 * @return An HttpStatus of OK signaling the successful entry of SoftSkillViolation objects.
	 */
	@RequestMapping(value = "/violation/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSoftSkillViolationAndReturnSoftSkillViolationID (@RequestBody ViolationFlagWrapper violationFlag) {
		Screening screening = screeningService.getScreening(violationFlag.screeningId);
		ViolationType vt = violationTypeService.getViolationType(violationFlag.violationTypeId);
		SoftSkillViolation ssv = new SoftSkillViolation(screening, vt, violationFlag.softSkillComment, violationFlag.violationTime);
		softSkillViolationService.save(ssv);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
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
	
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(@RequestBody StartingWrapper screeningInfo){
		Screening i = screeningService.setPending(screeningInfo);
		return new ResponseEntity<>(i.getScreeningId(),HttpStatus.OK);
	}
	
	
	/**
	 * Update the AboutMeCommentary variable of a Screening object
	 * 
	 * @param comment - CommentaryWrapper object that represents a comment and screeningID
	 * @return A ResponseEntity containing a success message and an HttpStatus of OK
	 */
	@RequestMapping(value="/screening/introcomment", method=RequestMethod.POST)
	public ResponseEntity<String> updateAboutMeCommentary (@RequestBody CommentWrapper comment){
		screeningService.updateAboutMeComment(comment.comment, comment.screeningId);
		return new ResponseEntity<>("Update introComment Completed", HttpStatus.OK); 
	}
	
	/**
	 * Persists general commentary to a Screening by its unique id.
	 * 
	 * @param comment - CommentaryWrapper that represent a comment and screeningId
	 * @return A ResponseEntity containing a success message and an HttpStatus of OK
	 */
	@RequestMapping(value = "/screening/generalcomment", method = RequestMethod.POST)
	public ResponseEntity<String> storeGeneralComment(@RequestBody CommentWrapper comment){
		screeningService.updateGeneralComment(comment.comment, comment.screeningId);
		return new ResponseEntity<>( "Update General Comment Success!",HttpStatus.OK);
	}
	
	/**
	 * End a Screening and update the information by screeningId
	 * 
	 * @param simpleScreening - the status, softSkillsVerdict, softSkillsCommentary, endDateTime, compositeScore, and screeningId of a completed screening.
	 * @return An HttpStatus of OK signalling the successful entry of a screening.
	 */
	@RequestMapping(value = "/screening/end", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> endScreening(@RequestBody EndingWrapper screeningInfo) {
		screeningService.endScreening(screeningInfo);
		scheduledScreeningService.updateStatus(screeningInfo.scheduledScreeningId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
