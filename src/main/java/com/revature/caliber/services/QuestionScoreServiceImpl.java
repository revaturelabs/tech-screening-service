package com.revature.caliber.services;

import com.revature.caliber.beans.SimpleQuestionScore;
import com.revature.caliber.data.QuestionScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service for the Question Score part of the Screening service.
 *
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@Service
public class QuestionScoreServiceImpl implements QuestionScoreService {

	@Autowired
	private QuestionScoreRepository questionScoreRepository;

	@Override
	public SimpleQuestionScore save(SimpleQuestionScore simpleQuestionScore) {
		if (simpleQuestionScore != null && simpleQuestionScore != new SimpleQuestionScore()) {
			return questionScoreRepository.save(simpleQuestionScore);
		} else {
			return null;
		}
	}

	@Override
	public List<SimpleQuestionScore> findByScreeningId(int screeningId) {
		return questionScoreRepository.findByScreeningId(screeningId);
	}


}
