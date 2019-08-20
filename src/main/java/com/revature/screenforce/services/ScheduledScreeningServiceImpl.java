package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.data.ScheduledScreeningRepository;

import java.util.List;

@Service
public class ScheduledScreeningServiceImpl implements ScheduledScreeningService {

	private ScheduledScreeningRepository scheduledScreeningRepository;

	@Autowired
	public ScheduledScreeningServiceImpl(ScheduledScreeningRepository scheduledScreeningRepository) {
		super();
		this.scheduledScreeningRepository = scheduledScreeningRepository;
	}

	@Override
	public List<ScheduledScreening> findByStatus(ScheduledStatus status) {
		List<ScheduledScreening> simpleScheduledScreenings = null;
		if (status.equals(ScheduledStatus.PENDING) || status.equals(ScheduledStatus.SCREENED)) {
			simpleScheduledScreenings = scheduledScreeningRepository.findAllByScheduledStatus(status);
		}
		return simpleScheduledScreenings;
	}

	@Override
	public void updateStatus(int scheduledScreeningId) {
		ScheduledScreening ss = scheduledScreeningRepository.findById(scheduledScreeningId).orElse(null);
		if (ss != null) {
			ss.setScheduledStatus(ScheduledStatus.SCREENED);
			scheduledScreeningRepository.save(ss);
		}
	}


}
