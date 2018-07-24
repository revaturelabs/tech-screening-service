package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.screening.data.ScheduledScreeningRepository;

@Service
public class ScheduledScreeningServiceImpl implements ScheduledScreeningService {

	@Autowired 
	private ScheduledScreeningRepository scheduledScreeningRepository;
	
	@Override
	public List<ScheduledScreening> findByStatus(String string) {
		List<ScheduledScreening> simpleScheduledScreenings = scheduledScreeningRepository.findByStatus(string);
		
		return simpleScheduledScreenings;
	}

	@Override
	public void updateStatus(String screened, Integer scheduledScreeningId) {
		scheduledScreeningRepository.updateStatus(screened, scheduledScreeningId);
	}

}
