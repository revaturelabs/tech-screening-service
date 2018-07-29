package com.revature.caliber.screening.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.data.ScreeningRepository;

@Service
public class ScreeningServiceImpl implements ScreeningService{
	
	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	@Autowired
	ScreeningRepository screeningRepository;
	
	@Autowired
	ScheduledScreeningRepository scheduledScreeningRepository;
	
	
	
	public Screening setPending(StartingWrapper screeningInfo) {
		Screening screening = new Screening();
		ScheduledScreening scheduledScreening = scheduledScreeningRepository.findOne(screeningInfo.scheduledScreeningId);
		scheduledScreening.setScheduledScreeningId(screeningInfo.scheduledScreeningId);
		screening.setScheduledScreening(scheduledScreening);
		screening.setStartDateTime(screeningInfo.beginTime);
		screening.setTrainerId(screeningInfo.trainerId);
		screening.setCandidate(scheduledScreening.getCandidate());
		screening.setStatus("Pending");
		return screeningRepository.save(screening);
	}

}
