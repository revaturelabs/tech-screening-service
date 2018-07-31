package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SimpleQuestionScore;
import com.revature.caliber.screening.data.QuestionScoreRepository;

/**
 * The service for the Question Score part of the Screening service.
 * 
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 *
 */
@Service
public class QuestionScoreServiceImpl implements QuestionScoreService {

	@Autowired
	private QuestionScoreRepository questionScoreRepository;
	
	

	@Override
	public void save(SimpleQuestionScore simpleQuestionScore) {
		questionScoreRepository.save(simpleQuestionScore);
	}
	

	@Override
	public List<SimpleQuestionScore> findByScreeningId(Integer screeningId) {
		return questionScoreRepository.findByScreeningId(screeningId);
	}


}
