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
			simpleScheduledScreenings = scheduledScreeningRepository.findByScheduledStatus(status);
		}
		return simpleScheduledScreenings;
	}

	@Override
	public void updateStatus(int scheduledScreeningId) {
		ScheduledScreening ss = scheduledScreeningRepository.findOne(scheduledScreeningId);
		if (ss!=null) {
			ss.setScheduledStatus("SCREENED");
			scheduledScreeningRepository.save(ss);
		}
	}
	

}
