package com.revature.screenforce.controllers;

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

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.services.QuestionScoreService;
import com.revature.screenforce.services.ScreeningService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Thomas Santillan| 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins </br>
 * 
 * The controller for incoming REST requests to the Question Score part of the Screening service.
 */
@CrossOrigin
@RestController
@RequestMapping("/questionScore")
@ApiModel(value = "Question Score Controller", description = "A REST controller to handle HTTP requests that deal with Question Scores")
public class QuestionScoreController {

	/** The question score service. */
	private QuestionScoreService questionScoreService;	
	
	/** The screening service. */
	private ScreeningService screeningService;
	
	/**
	 * Instantiates a new question score controller.
	 *
	 * @param questionScoreService the question score service
	 * @param screeningService the screening service
	 */
	@Autowired
	public QuestionScoreController(QuestionScoreService questionScoreService, ScreeningService screeningService) {
		this.questionScoreService = questionScoreService;
		this.screeningService = screeningService;
	}

	
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
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SimpleQuestionScore> saveQuestionScore(@RequestBody SimpleQuestionScore questionScore) {
		SimpleQuestionScore newScore = questionScoreService.save(questionScore);
		if (newScore != null) {
			return new ResponseEntity<>(newScore, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(newScore, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets the simple question scores...
	 * 
	 * All of them.
	 *
	 * @return the simple question scores
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleQuestionScore>> getSimpleQuestionScores() {
		List<SimpleQuestionScore> simpleQuestionScoreList = questionScoreService.getAll();
		return new ResponseEntity<>(simpleQuestionScoreList, HttpStatus.OK);
	}
	
	/**
	 * Gets QuestionScores of given id.
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
