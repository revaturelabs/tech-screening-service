package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.data.ScheduledScreeningRepository;

import java.util.List;

/**
 * The implementation of the Scheduled Screening Service.
 */
@Service
public class ScheduledScreeningServiceImpl implements ScheduledScreeningService {

	/** The scheduled screening repository. */
	private ScheduledScreeningRepository scheduledScreeningRepository;
	
	/**
	 * Instantiates a new scheduled screening service.
	 *
	 * @param scheduledScreeningRepository the scheduled screening repository
	 */
	@Autowired
	public ScheduledScreeningServiceImpl (ScheduledScreeningRepository scheduledScreeningRepository) {
		this.scheduledScreeningRepository = scheduledScreeningRepository;
	}

	/**
	 * Find all scheduled screenings by status.
	 *
	 * @param status the status
	 * @return the list
	 */
	@Override
	public List<ScheduledScreening> findByStatus(ScheduledStatus status) {
		List<ScheduledScreening> simpleScheduledScreenings = null;
		if (status.equals(ScheduledStatus.PENDING) || status.equals(ScheduledStatus.SCREENED)) {
			simpleScheduledScreenings = scheduledScreeningRepository.findAllByScheduledStatus(status);
		}
		return simpleScheduledScreenings;
	}

	/**
	 * Sets the status of a scheduled screening to SCREENED.
	 *
	 * @param scheduledScreeningId the scheduled screening id
	 */
	@Override
	public void updateStatus(int scheduledScreeningId) {
		ScheduledScreening ss = scheduledScreeningRepository.findById(scheduledScreeningId).orElse(null);
		if (ss != null) {
			ss.setScheduledStatus(ScheduledStatus.SCREENED);
			scheduledScreeningRepository.save(ss);
		}
	}

}
