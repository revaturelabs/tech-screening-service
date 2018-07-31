package com.revature.caliber.screening.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.wrappers.StartingWrapper;

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
		ScheduledScreening scheduledScreening = scheduledScreeningRepository.findOne(screeningInfo.scheduledScreeningId);
		screening.setScheduledScreening(scheduledScreening);
		screening.setStartDateTime(screeningInfo.getBeginTime());
		screening.setTrainerId(screeningInfo.getTrainerId());
		screening.setCandidate(scheduledScreening.getCandidate());
		screening.setSkillType(screeningInfo.getSkillTypeId());
		screening.setStatus("PENDING");
		return screeningRepository.save(screening);
	}

}
