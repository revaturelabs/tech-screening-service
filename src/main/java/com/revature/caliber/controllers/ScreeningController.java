package com.revature.caliber.controllers;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.services.ScheduledScreeningService;
import com.revature.caliber.services.ScreeningService;
import com.revature.caliber.services.SoftSkillViolationService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@CrossOrigin
@RestController
@RequestMapping("/screening")
@ApiModel(value = "Screening Controller", description = "A REST controller to handle HTTP requests that deal with Screenings and ScheduledScreenings")
public class ScreeningController {

	@Autowired
	ScheduledScreeningService scheduledScreeningService;

	@Autowired
	ScreeningService screeningService;

	@Autowired
	SoftSkillViolationService softSkillViolationService;

	/**
	 * Returns a list of softSkillViolation objects by ScreeningID
	 *
	 * @param screeningId - the unique id of a Screening
	 * @return List of SoftSkillViolation objects
	 */
	@ApiOperation(value = "Get all the violations for a Screening", response = SoftSkillViolation.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retrieved all violations")})
	@RequestMapping(value = "/{id}/violations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>> softSkillViolationByScreeningID(@PathVariable(value = "id") int screeningId) {
		List<SoftSkillViolation> ssv = softSkillViolationService.getAllByScreeningId(screeningId);

		return new ResponseEntity<>(ssv, HttpStatus.OK);
	}

	/**
	 * Get screenings based on the status provided.
	 *
	 * @return - List of ScheduledScreening objects corresponding to status.
	 */
	@ApiOperation(value = "Get all pending Scheduled Screenings", response = ScheduledScreening.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retrieved all Scheduled Screenings")})
	@RequestMapping(value = "/scheduled", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduledScreening>> getAllScheduledScreenings() {
		List<ScheduledScreening> scheduledScreenings = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING);

		return new ResponseEntity<>(scheduledScreenings, HttpStatus.OK);
	}

	/**
	 * Method to create a new Screening
	 *
	 * @param screening Screening to
	 * @return New screening object
	 */
	@ApiOperation(value = "Add a new Screening", response = Screening.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Screening added"),
			@ApiResponse(code = 403, message = "Bad request, screening not added")
	})
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Screening> createScreening(@Valid @RequestBody Screening screening) {
		Screening newScreen = screeningService.createScreening(screening);
		if (newScreen != null) {
			return new ResponseEntity<>(newScreen, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Method to update a Screening. Replaces the previous mappings to add commentary, /start, and /end
	 *
	 * @param screening Screening to update
	 * @return Updated screening object
	 */
	@ApiOperation(value = "Update a screening", response = Screening.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Screening updated"),
			@ApiResponse(code = 403, message = "Bad request, screening not updated")
	})
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Screening> updateScreening(@Valid @RequestBody Screening screening) {
		Screening updateScreening = screeningService.updateScreening(screening);
		if (updateScreening != null) {
			return new ResponseEntity<>(updateScreening, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
