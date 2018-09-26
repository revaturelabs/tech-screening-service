package com.revature.caliber.services;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.data.ScheduledScreeningRepository;
import com.revature.caliber.data.ScreeningRepository;
import com.revature.caliber.wrappers.EndingWrapper;
import com.revature.caliber.wrappers.StartingWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScreeningServiceImpl implements ScreeningService{
	
	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	@Autowired
	ScreeningRepository screeningRepository;
	
	@Autowired
	ScheduledScreeningRepository scheduledScreeningRepository;
	
	
	@Override
	public Screening setPending(StartingWrapper screeningInfo) {
		Screening screening = new Screening();
		ScheduledScreening scheduledScreening = scheduledScreeningRepository.findOne(screeningInfo.getScheduledScreeningId());
		screening.setScreeningId(0);
		screening.setScheduledScreening(scheduledScreening);
		screening.setStartDateTime(screeningInfo.getBeginTime());
		screening.setTrainerId(screeningInfo.getTrainerId());
		screening.setCandidate(scheduledScreening.getCandidate());
		screening.setSkillType(screeningInfo.getSkillTypeId());
		screening.setStatus("PENDING");
		return screeningRepository.save(screening);
	}

	@Override
	public Screening getScreening(int id) {
		return screeningRepository.findOne(id);
	}
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
		Screening s = screeningRepository.findOne(screeningInfo.getScreeningId());
		s.setStatus(screeningInfo.getStatus());
		s.setSoftSkillsVerdict(screeningInfo.isSoftSkillVerdict());
		s.setSoftSkillCommentary(screeningInfo.getSoftSkillCommentary());
		s.setEndDateTime(screeningInfo.getEndDateTime());
		screeningRepository.save(s);	
	}
 
}
