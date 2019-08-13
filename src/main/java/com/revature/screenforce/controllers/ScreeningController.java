package com.revature.screenforce.controllers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.services.ScheduledScreeningService;
import com.revature.screenforce.services.ScreeningService;
import com.revature.screenforce.services.SoftSkillViolationService;

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
	 * Returns a list Screening objects
	 *
	 * @return List of Screening objects
	 */
	@ApiOperation(value = "Get all Screening", response = Screening.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retrieved All Screening")})
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Screening>> getAllScreening() {
		List<Screening> ssv = screeningService.getAllScreening();
			return new ResponseEntity<>(ssv, HttpStatus.OK);
	}
	
	/**
	 * Returns a single Screening record by ScreeningID
	 *
	 * @param screeningId - the unique id of a Screening
	 * @return Screening Object
	 */
	@ApiOperation(value = "Get a Screening", response = Screening.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retrieved Screening"), 
			@ApiResponse(code = 404, message = "Screening Not Found")
			})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Screening> getScreeningById(@PathVariable(value = "id") int id) {
		Screening ssv = screeningService.getScreeningById(id);
		if(ssv != null ) {
			return new ResponseEntity<>(ssv, HttpStatus.OK);
		}
		return new ResponseEntity<>(ssv, HttpStatus.NOT_FOUND);
	}

	/**
	 * Returns a list of softSkillViolation objects by ScreeningID
	 *
	 * @param screeningId - the unique id of a Screening
	 * @return List of SoftSkillViolation objects
	 */
	@ApiOperation(value = "Get all the violations for a Screening", response = SoftSkillViolation.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieved all violations") })
	@RequestMapping(value = "/{id}/violations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>> softSkillViolationByScreeningID(
			@PathVariable(value = "id") int screeningId) {
		List<SoftSkillViolation> ssv = softSkillViolationService.getAllByScreeningId(screeningId);

		return new ResponseEntity<>(ssv, HttpStatus.OK);
	}

	/**
	 * Get screenings based on the status provided.
	 *
	 * @return - List of ScheduledScreening objects corresponding to status.
	 */
	@ApiOperation(value = "Get all pending Scheduled Screenings", response = ScheduledScreening.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieved all Scheduled Screenings") })
	// making it scheduled into having the status coming in as Paramater would be a better way.
	@RequestMapping(value = "/scheduled", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduledScreening>> getAllScheduledScreenings() {
		List<ScheduledScreening> scheduledScreenings = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING);
		return new ResponseEntity<>(scheduledScreenings, HttpStatus.OK);
	}

	/**
	 * Method to create a new Screening
	 *
	 * @param Screening to create
	 * @return New screening object
	 */
	@ApiOperation(value = "Add a new Screening", response = Screening.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Screening added"),
			@ApiResponse(code = 400, message = "Bad request, screening not added") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Screening> createScreening(@Valid @RequestBody Screening screening) {
		Screening newScreen = screeningService.createScreening(screening);
		if (newScreen != null) {
			return new ResponseEntity<>(newScreen, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Method to update a Screening. 
	 *
	 * @param screeningId to update
	 * @return Updated screening object
	 */
	@ApiOperation(value = "Update a screening", response = Screening.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Screening updated"),
			@ApiResponse(code = 400, message = "Bad request, screening not updated") })
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Screening> updateScreening(@PathVariable(value = "id") int id, @RequestBody Screening newSc) {
		if (screeningService.existsById(id)) {
			Screening updateScreening = screeningService.updateScreening(newSc);
			return new ResponseEntity<>(updateScreening, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
