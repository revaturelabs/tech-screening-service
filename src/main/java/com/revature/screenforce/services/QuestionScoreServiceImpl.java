package com.revature.screenforce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.data.QuestionScoreRepository;

/**
 * The implementation of the question score service.
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins 
 * 
 */
@Service
public class QuestionScoreServiceImpl implements QuestionScoreService {

	/** The question score repository. */
	private QuestionScoreRepository questionScoreRepository;
	
	/**
	 * Instantiates a new question score service.
	 *
	 * @param questionScoreRepository the question score repository
	 */
	@Autowired
	public QuestionScoreServiceImpl(QuestionScoreRepository questionScoreRepository) {
		this.questionScoreRepository = questionScoreRepository;
	}

	/**
	 * Saves a new simple question score.
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
	 * Find a screening by it's id.
	 *
	 * @param screeningId the screening id
	 * @return the list
	 */
	@Override
	public List<SimpleQuestionScore> findByScreeningId(int screeningId) {
		return questionScoreRepository.findAllByScreeningScreeningId(screeningId);
	}
	
	/**
	 * Check if a screening exists by id.
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
