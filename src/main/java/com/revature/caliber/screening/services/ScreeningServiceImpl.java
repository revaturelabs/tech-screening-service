package com.revature.caliber.screening.services;

import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SimpleScheduledScreening;
import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.screening.data.ScheduledScreeningRepository;
import com.revature.caliber.screening.data.ScreeningRepository;

@Service("screeningService")
public class ScreeningServiceImpl implements ScreeningService{
	
	private ScheduledScreeningRepository ssr;
	private ScreeningRepository sr;

	@Override
	public Integer tempName(ScheduledScreening scheduledScreening) {
		SimpleScheduledScreening simpleScheduledScreening = ssr.findByScheduledScreeningId(scheduledScreening.getScheduledScreeningId());
		SimpleScreening simpleScreening = sr.findBySimpleScheduledScreening(simpleScheduledScreening);
		return sr.screeningId(simpleScreening);
	}
}
