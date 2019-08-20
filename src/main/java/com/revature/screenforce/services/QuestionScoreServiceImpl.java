package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.data.QuestionScoreRepository;

import java.util.List;

/**
 * The service for the Question Score part of the Screening service.
 *
 * @author Thomas Santillan | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@Service
public class QuestionScoreServiceImpl implements QuestionScoreService {

	private QuestionScoreRepository questionScoreRepository;

	@Autowired
	public QuestionScoreServiceImpl(QuestionScoreRepository questionScoreRepository) {
		super();
		this.questionScoreRepository = questionScoreRepository;
	}

	@Override
	public SimpleQuestionScore save(SimpleQuestionScore simpleQuestionScore) {
		if (simpleQuestionScore != null && !(simpleQuestionScore.equals(new SimpleQuestionScore()))) {
			return questionScoreRepository.save(simpleQuestionScore);
		} else {
			return null;
		}
	}

	@Override
	public List<SimpleQuestionScore> findByScreeningId(int screeningId) {
		return questionScoreRepository.findAllByScreeningScreeningId(screeningId);
	}
	
	@Override
	public boolean existsById(int id) {
		return questionScoreRepository.existsById(id);
	}

	//5/28 JU - addition for back-end re-factor
	public List<SimpleQuestionScore> getAll() {
		return questionScoreRepository.findAll();
	}
}
