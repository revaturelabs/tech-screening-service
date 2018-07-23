package com.revature.caliber.screening.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SimpleQuestionScore;
import com.revature.caliber.screening.data.QuestionScoreRepository;

@Service
public class QuestionScoreService {

	@Autowired
	private QuestionScoreRepository questionScoreRepository;
	
	
	/**
	 * Saves given score
	 * 
	 * @param simpleQuestionScore Question score to be saved
	 */
	public void save(SimpleQuestionScore simpleQuestionScore) {
		questionScoreRepository.save(simpleQuestionScore);
	}
	
	/**
	 * Finds question scores containing given screening id
	 * 
	 * @param screeningId Id of Screening
	 * @return List of question scores
	 */
	public List<SimpleQuestionScore> findByScreeningId(Integer screeningId) {
		return questionScoreRepository.findByScreeningId(screeningId);
	}


}
