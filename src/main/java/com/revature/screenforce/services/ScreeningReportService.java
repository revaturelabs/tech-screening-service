package com.revature.screenforce.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//5/26 JU - this service contains methods that were in the service tier that is being removed from the reports application as a part of the May 2019 back-end refactor. 
@Service
public class ScreeningReportService {

	//variables
	@Autowired SoftSkillViolationRepository softSkillViolationRepository;
	@Autowired ScreeningRepository screeningRepository;
	@Autowired ViolationTypeRepository violationTypeRepository;
	@Autowired ScheduledScreeningRepository scheduledScreeningRepository;
	@Autowired QuestionScoreRepository questionScoreRepository;

	
	//methods
	public List<Screening> getAllScreenings() {
		return this.screeningRepository.findAll();
	}
	
	public List<SoftSkillViolation> getAllSoftSkillViolations() {
		return this.softSkillViolationRepository.findAll();
	}
	
	//5/26 JU - NOTE: type was QuestionScore in reports application and SimpleQuestionScore in the screening service. I'm leaving the type as the type that was in screening.
//	public List<SimpleQuestionScore> getAllQuestionScores() {
//		return this.questionScoreRepository.findAll();
//	}
// 	
//	private List<ReportData.BarChartData> violationsByType(List<Screening> screenings){
//		/*
//		 * Gets all violations from each screening and returns a List of 
//		 * bar chart data to display in the front end.
//		 * @param screenings List of screenings from specified time period.
//		 * @return List of violations committed, formatted for a bar chart.
//		 */
//		Map<String, Integer> countSoftSkillViolation = new HashMap<>();
//		for (Screening s : screenings) {
//			List<SoftSkillViolation> softSkillsViolations = softSkillViolationRepository.findAllByScreeningId(s.getScreeningId());
//			for (SoftSkillViolation softSkillsViolation : softSkillsViolations) {
//				String key = softSkillsViolation.getViolationType().getViolationTypeText();
//				if (!countSoftSkillViolation.containsKey(key)) {
//					countSoftSkillViolation.put(key, 0);
//				}
//				countSoftSkillViolation.replace(key, countSoftSkillViolation.get(key) + 1);
//			}
//		}
//		
//		List<ReportData.BarChartData> violationsByType = new ArrayList<BarChartData>();
//		for (String ssv : countSoftSkillViolation.keySet()) {
//			violationsByType.add(new ReportData.BarChartData(
//					ssv,
//					countSoftSkillViolation.get(ssv)
//					));
//		}
//		
//		return violationsByType;
//	}
//	
	//5/26 JU - service method that does not pull from a DB
	private Integer numApplicantsPassed(List<Screening> screenings) {
		/*
		 * Returns an integer amount of applicants with a passing composite score above 70 .
		 * @param  screenings List of screenings according to the given date range.
		 * @return numApplicantsPassed from screenings
		 */
		Integer numApplicantsPassed = 0;
		for (Screening s : screenings) {
            double compScore = s.getCompositeScore();
            if (compScore >= 70) {
                numApplicantsPassed +=1;
            }
        }
		return numApplicantsPassed;
	}
	
	
	//5/26 JU - this service method does not pull from a DB. 
	private Integer numApplicantsFailed(List<Screening> screenings) {
		/*
		 * Returns an integer amount of applicants with a failing composite score below 70 .
		 * @param  screenings List of screenings according to the given date range.
		 * @return numApplicantsFailed from screenings
		 */
		Integer numApplicantsFailed = 0;
		for (Screening s : screenings) {
            double compScore = s.getCompositeScore();
            if (compScore < 70) {
                numApplicantsFailed +=1;
            }
        }
		return numApplicantsFailed;
	}
	
	
//  5/26 JU - s-one needs to look into handling having a LocalDate input where the DB uses a Date here.  

//	private List<Screening> getScreenings(LocalDate startDate, LocalDate endDate) {
//		/*
//		 * Overloaded for /getWeeksReport. Returns all screenings scores in a date range.
//		 * @return List<QuestionScore>
//		 */
//		List<Screening> screenings;
//		List<Screening> out = new ArrayList<Screening>();
//		
//		//JU 5/26 Adding manipulating inputs to match data in repository
//		
//		
//		screenings = screeningRepository.findAll();
//		
//		for (Screening s : screenings) {
//			if (s.getEndDateTime().isAfter(startDate) && s.getEndDateTime().isBefore(endDate)) {
//				out.add(s);
//			}
//		}
//		return out;
//	}
	
	
	//5/26 JU QuestionScore from reports service --> SimpleQuestionScore 
	private List<SimpleQuestionScore> getQuestionScores(Integer screenerId) {
		/*
		 * Overloaded for /getScreenerReport. Returns all question scores associated with an individual screener.
		 * @return List<QuestionScore>
		 */
		
		List<SimpleQuestionScore> out = new ArrayList<SimpleQuestionScore>();
		
		for (SimpleQuestionScore qs : questionScoreRepository.findAll()) {
			if ((qs.getScreening().getScreenerId() == screenerId)) {
				out.add(qs);
			}
		}
		return out;
	}
	
	private List<Screening> getScreenings() {
		/*
		 * Overloaded for /getTotalReport. Returns all screenings.
		 * @return List<QuestionScore>
		 */
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		screenings = screeningRepository.findAll();
	
		out = screenings;
		
		return out;
	}
	
	//5/26 JU - QuestionScore from reports service --> SimpleQuestionScore here 
	private List<SimpleQuestionScore> getQuestionScores() {
		/*
		 * Overloaded for /getTotalReport. Returns all question scores.
		 * @return List<QuestionScore>
		 */
		
		List<SimpleQuestionScore> out = new ArrayList<SimpleQuestionScore>();
		
		for (SimpleQuestionScore qs : questionScoreRepository.findAll()) {
			out.add(qs);
		}
		return out;
	}
	
	
}
