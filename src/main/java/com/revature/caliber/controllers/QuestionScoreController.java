package com.revature.caliber.controllers;

import com.revature.caliber.beans.SimpleQuestionScore;
import com.revature.caliber.services.QuestionScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller for incoming REST requests to the Question Score part of the Screening service.
 * 
 * @author Thomas Santillan| 1805-WVU-MAY29 | Richard Orr
 *
 */
@RestController
public class QuestionScoreController {

	@Autowired
	private QuestionScoreService questionScoreService;

	/**
	 * Create a new Question Score and persist it in the database.
	 * 
	 * @param questionScore
	 * @return Response entity with HttpStatus OK
	 */
	@RequestMapping(value = "/question/score", method = RequestMethod.POST)
	public ResponseEntity<Void> questionScore(@RequestBody SimpleQuestionScore questionScore) {
		questionScoreService
				.save(new SimpleQuestionScore(questionScore.getQuestionId(), questionScore.getScreeningId(),
						questionScore.getScore(), questionScore.getComment(), questionScore.getBeginTime()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Gets scores of given id
	 * 
	 * @param screeningId Id of Screening
	 * @return List of Question scores
	 */
	@RequestMapping(value = "question/score/{screeningId}", method = RequestMethod.GET)
	public ResponseEntity<List<SimpleQuestionScore>> getScoresByScreeningId(
			@PathVariable("screeningId") Integer screeningId) {
		List<SimpleQuestionScore> scoreList = questionScoreService.findByScreeningId(screeningId);
		return new ResponseEntity<>(scoreList, HttpStatus.OK);
	}

}
