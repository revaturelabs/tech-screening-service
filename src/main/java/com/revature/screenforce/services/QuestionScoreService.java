package com.revature.screenforce.services;

import java.util.List;

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.beans.ViolationType;

/**
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins </br>
 * 
 * The interface for the Question Score part of the Screening service.
 */
public interface QuestionScoreService {

	/**
	 * Saves given score.
	 *
	 * @param simpleQuestionScore Question score to be saved
	 * @return the simple question score
	 */
	SimpleQuestionScore save(SimpleQuestionScore simpleQuestionScore);

	/**
	 * Finds question scores containing given screening id.
	 *
	 * @param screeningId Id of Screening to filter by
	 * @return List of question scores
	 */
	List<SimpleQuestionScore> findByScreeningId(int screeningId);
	
	/**
	 * Check if the score exist by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean existsById(int id);
	
	/**
	 * Returns all question scores.
	 *
	 * @return the all
	 */
	List<SimpleQuestionScore> getAll();

}
