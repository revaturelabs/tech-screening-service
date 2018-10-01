package com.revature.caliber.controllers;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.services.ScheduledScreeningService;
import com.revature.caliber.services.ScreeningService;
import com.revature.caliber.services.SoftSkillViolationService;
import com.revature.caliber.services.ViolationTypeService;
import com.revature.caliber.wrappers.CommentWrapper;
import com.revature.caliber.wrappers.EndingWrapper;
import com.revature.caliber.wrappers.StartingWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
	@RequestMapping(value = "/screening/{id}/violation/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>> softSkillViolationByScreeningID(@PathVariable(value = "id") Integer id) {
		List<SoftSkillViolation> ssv = softSkillViolationService.getAllByScreeningId(id);

		return new ResponseEntity<>(ssv, HttpStatus.OK);
	}

	/**
	 * Get screenings based on the status provided.
	 *
	 * @param status - A string notifying whether the screening is pending or complete.
	 * @return - List of SimpleScreening objects corresponding to status.
	 */
	@RequestMapping(value = "/screening/scheduled", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduledScreening>> getAllScheduledScreenings() {
		List<ScheduledScreening> scheduledScreenings = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING);

		return new ResponseEntity<>(scheduledScreenings, HttpStatus.OK);
	}

	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(@RequestBody StartingWrapper screeningInfo) {
		Screening i = screeningService.setPending(screeningInfo);
		return new ResponseEntity<>(i.getScreeningId(), HttpStatus.OK);
	}


	/**
	 * Update the AboutMeCommentary variable of a Screening object
	 *
	 * @param comment - CommentaryWrapper object that represents a comment and screeningID
	 * @return A ResponseEntity containing a success message and an HttpStatus of OK
	 */
	@RequestMapping(value = "/screening/introcomment", method = RequestMethod.POST)
	public ResponseEntity<String> updateAboutMeCommentary(@RequestBody CommentWrapper comment) {
		screeningService.updateAboutMeComment(comment.getComment(), comment.getScreeningId());
		return new ResponseEntity<>("Update introComment Completed", HttpStatus.OK);
	}

	/**
	 * Persists general commentary to a Screening by its unique id.
	 *
	 * @param comment - CommentaryWrapper that represent a comment and screeningId
	 * @return A ResponseEntity containing a success message and an HttpStatus of OK
	 */
	@RequestMapping(value = "/screening/generalcomment", method = RequestMethod.POST)
	public ResponseEntity<String> storeGeneralComment(@RequestBody CommentWrapper comment) {
		screeningService.updateGeneralComment(comment.getComment(), comment.getScreeningId());
		return new ResponseEntity<>("Update General Comment Success!", HttpStatus.OK);
	}

	/**
	 * End a Screening and update the information by screeningId
	 *
	 * @param simpleScreening - the status, softSkillsVerdict, softSkillsCommentary, endDateTime, compositeScore, and screeningId of a completed screening.
	 * @return An HttpStatus of OK signaling the successful entry of a screening.
	 */
	@RequestMapping(value = "/screening/end", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> endScreening(@RequestBody EndingWrapper screeningInfo) {
		screeningService.endScreening(screeningInfo);
		scheduledScreeningService.updateStatus(screeningInfo.getScheduledScreeningId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
