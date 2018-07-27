package com.revature.caliber.screening.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.wrapper.EndingWrapper;

@Service
public class ScreeningServiceImpl implements ScreeningService{
	@Autowired
	private ScreeningRepository screeningRepository;
	
	/**
	 * Update aboutMeComment by ScreeningId
	 * 
	 * @param aboutMeComment - the comment to be persisted to the database.
	 * @param screeningId - the unique id of a screening
	 */
	@Override
	public void updateAboutMeComment(String aboutMeComment, Integer screeningId) {
		Screening s = screeningRepository.findOne(screeningId);
		s.setAboutMeCommentary(aboutMeComment);
		screeningRepository.save(s);
	}
	
	/**
	 * Update GeneralComment By ScreeningId
	 * 
	 * @param generalComment - the comment to be persisted to the database
	 * @param screeningId - the unique id of a screening
	 */
	@Override
	public void updateGeneralComment(String generalComment, Integer screeningId) {
		Screening s = screeningRepository.findOne(screeningId);
		s.setGeneralCommentary(generalComment);
		screeningRepository.save(s);
	}

	/**
	 * Update info after a Screening ends 
	 * 
	 * @param EndingWrapper - Screening info to be updated after a Screening ends
	 * 
	 */
	@Override
	public void endScreening(EndingWrapper screeningInfo) {
		Screening s = screeningRepository.findOne(screeningInfo.screeningId);
		s.setStatus(screeningInfo.status);
		s.setSoftSkillsVerdict(screeningInfo.softSkillVerdict);
		s.setSoftSkillCommentary(screeningInfo.softSkillCommentary);
		s.setEndDateTime(screeningInfo.endDateTime);
		screeningRepository.save(s);	
	}

}
