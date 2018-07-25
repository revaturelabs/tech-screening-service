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
	public List<ScheduledScreening> findByStatus(String status) {
		List<ScheduledScreening> simpleScheduledScreenings = null;
		if ("PENDING".equals(status) || "SCREENED".equals(status)) {
			simpleScheduledScreenings = scheduledScreeningRepository.findByStatus(status);
		}
		return simpleScheduledScreenings;
	}

	@Override
	public void updateStatus(String screened, Integer scheduledScreeningId) throws IllegalArgumentException {
		if ("PENDING".equals(screened) || "SCREENED".equals(screened)) {
			scheduledScreeningRepository.updateStatus(screened, scheduledScreeningId);
		} else {
			throw new IllegalArgumentException("Status must be 'PENDING' or 'SCREENED'");
		}
	}
	

}
