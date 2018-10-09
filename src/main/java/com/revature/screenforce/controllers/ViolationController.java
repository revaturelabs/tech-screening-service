package com.revature.screenforce.controllers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.services.SoftSkillViolationService;
import com.revature.screenforce.services.ViolationTypeService;

import java.util.List;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@CrossOrigin
@RestController
@RequestMapping("/violation")
@ApiModel(value = "Violation Controller", description = "A REST controller to handle HTTP requests that deal with Violations")
public class ViolationController {
	@Autowired
	SoftSkillViolationService softSkillViolationService;

	@Autowired
	ViolationTypeService violationTypeService;

	/**
	 * Returns a list of ViolationType objects representing all held in the database
	 *
	 * @return List of ViolationType objects
	 */
	@ApiOperation(value = "Get all violation types", response = ViolationType.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "All violation types returned")})
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ViolationType>> getViolationTypes() {
		List<ViolationType> vios = violationTypeService.getAll();
		return new ResponseEntity<>(vios, HttpStatus.OK);
	}

	/**
	 * Delete a soft skill violation by its unique id
	 *
	 * @param id - the unique id of the SoftSkillViolation object to be deleted
	 * @return A ResponseEntity that contains a delete completed message and an HttpStatus of OK.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a violation by Id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Violation not found"),
			@ApiResponse(code = 200, message = "Violation deleted")
	})
	public ResponseEntity<String> deleteSoftSkillViolation(@PathVariable(value = "id") int id) {
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
	 * @param violation The new SoftSkillsViolation
	 * @return An HttpStatus of OK signaling the successful entry of SoftSkillViolation objects.
	 */
	@ApiOperation(value = "Add a new SoftSkillViolation", response = SoftSkillViolation.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SoftSkillViolation added"),
			@ApiResponse(code = 400, message = "Bad SoftSkillViolation")
	})
	@RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SoftSkillViolation> createSoftSkillViolationAndReturnSoftSkillViolationID(@RequestBody SoftSkillViolation violation) {
		if (violation != null && !violation.equals(new SoftSkillViolation())) {
			SoftSkillViolation ssv = softSkillViolationService.save(violation);
			return new ResponseEntity<>(ssv, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
