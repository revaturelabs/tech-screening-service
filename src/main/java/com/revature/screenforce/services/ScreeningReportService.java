package com.revature.screenforce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.data.QuestionScoreRepository;
import com.revature.screenforce.data.ScheduledScreeningRepository;
import com.revature.screenforce.data.ScreeningRepository;
import com.revature.screenforce.data.SoftSkillViolationRepository;
import com.revature.screenforce.data.ViolationTypeRepository;

@Service
public class ScreeningReportService {

	//variables
	@Autowired SoftSkillViolationRepository softSkillViolationRepository;
	@Autowired ScreeningRepository screeningRepository1;
	@Autowired ViolationTypeRepository violationTypeRepository;
	@Autowired ScheduledScreeningRepository scheduledScreeningRepository;
	@Autowired QuestionScoreRepository questionScoreRepository;

	
	//methods
	public List<Screening> getAllScreenings() {
		return this.screeningRepository1.findAll();
	}
	
	public List<SoftSkillViolation> getAllSoftSkillViolations() {
		return this.softSkillViolationRepository.findAll();
	}
	//5/26 JU - NOTE: type was QuestionScore in reports application and SimpleQuestionScore in the screening service. I'm leaving the type as the type that was in screening.
	public List<SimpleQuestionScore> getAllQuestionScores() {
		return this.questionScoreRepository.findAll();
	}
 	
	
}
