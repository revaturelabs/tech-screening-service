package com.revature.screenforce.controllers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.services.QuestionScoreService;
import com.revature.screenforce.services.ScreeningService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

/**
 * The controller for incoming REST requests to the Question Score part of the Screening service.
 *
 * @author Thomas Santillan| 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@CrossOrigin
@RestController
@RequestMapping("/questionScore")
@ApiModel(value = "Question Score Controller", description = "A REST controller to handle HTTP requests that deal with Question Scores")
public class QuestionScoreController {

	@Autowired
	private QuestionScoreService questionScoreService;
	
	@Autowired
	private ScreeningService screeningService;

	/**
	 * Create a new Question Score and persist it in the database.
	 *
	 * @param questionScore New object to persist
	 * @return Response entity with HttpStatus OK
	 */
	@ApiOperation(value = "Create a new score for a Question")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "QuestionScore created"),
			@ApiResponse(code = 400, message = "Could not create QuestionScore")
	})
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<SimpleQuestionScore> saveQuestionScore(@RequestBody SimpleQuestionScore questionScore) {
		SimpleQuestionScore newScore = questionScoreService.save(questionScore);
		if (newScore != null) {
			return new ResponseEntity<>(newScore, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(newScore, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets QuestionScores of given id
	 *
	 * @param screeningId Id of Screening
	 * @return List of Question scores
	 */
	@ApiOperation(value = "Get QuestionScores for a screening", response = SimpleQuestionScore.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "All QuestionScores for Screening returned"),
			@ApiResponse(code = 404, message = "Screening ID not found.")
			})
	@RequestMapping(value = "/{screeningId}", method = RequestMethod.GET)
	public ResponseEntity<List<SimpleQuestionScore>> getScoresByScreeningId(
			@PathVariable("screeningId") Integer screeningId) {
		List<SimpleQuestionScore> scoreList = null;
		if(!screeningService.existsById(screeningId))
		{
			return new ResponseEntity<>(scoreList, HttpStatus.NOT_FOUND);
		}
		else {
			scoreList = questionScoreService.findByScreeningId(screeningId);
			return new ResponseEntity<>(scoreList, HttpStatus.OK);
		}
	}

}
