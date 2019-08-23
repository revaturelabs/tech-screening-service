package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.data.QuestionScoreRepository;

import java.util.List;

/**
 * The implementation of the question score service. </br>
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins 
 * 
 */
@Service
public class QuestionScoreServiceImpl implements QuestionScoreService {

	/** The question score repository. */
	private QuestionScoreRepository questionScoreRepository;
	
	/**
	 * Instantiates a new question score service.  Autowired.
	 *
	 * @param questionScoreRepository the question score repository
	 */
	@Autowired
	public QuestionScoreServiceImpl(QuestionScoreRepository questionScoreRepository) {
		this.questionScoreRepository = questionScoreRepository;
	}

	/**
	 * Save a new simple question score.
	 *
	 * @param simpleQuestionScore the simple question score
	 * @return the simple question score
	 */
	@Override
	public SimpleQuestionScore save(SimpleQuestionScore simpleQuestionScore) {
		if (simpleQuestionScore != null && !(simpleQuestionScore.equals(new SimpleQuestionScore()))) {
			return questionScoreRepository.save(simpleQuestionScore);
		} else {
			return null;
		}
	}

	/**
	 * Find by screening id.
	 *
	 * @param screeningId the screening id
	 * @return the list
	 */
	@Override
	public List<SimpleQuestionScore> findByScreeningId(int screeningId) {
		return questionScoreRepository.findAllByScreeningScreeningId(screeningId);
	}
	
	/**
	 * Check if it exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	public boolean existsById(int id) {
		return questionScoreRepository.existsById(id);
	}

	/**
	 * Gets all simple question scores.
	 *
	 * @return the all
	 */
	public List<SimpleQuestionScore> getAll() {
		return questionScoreRepository.findAll();
	}
}
