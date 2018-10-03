package com.revature.caliber.services;

import com.revature.caliber.beans.SimpleQuestionScore;

import java.util.List;

/**
 * The service for the Question Score part of the Screening service.
 * 
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 *
 */
public interface QuestionScoreService {

	/**
	 * Saves given score
	 * 
	 * @param simpleQuestionScore Question score to be saved
	 */
	SimpleQuestionScore save(SimpleQuestionScore simpleQuestionScore);

	/**
	 * Finds question scores containing given screening id
	 * 
	 * @param screeningId Id of Screening to filter by
	 * @return List of question scores
	 */
	List<SimpleQuestionScore> findByScreeningId(int screeningId);

}
