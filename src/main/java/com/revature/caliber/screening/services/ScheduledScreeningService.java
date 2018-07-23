package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;

/**
 * Business logic for Scheduled Screening operations
 */
public interface ScheduledScreeningService {
	
	/**
	 * Get ScheduledScreening by status
	 * 
	 * @param string
	 * @return list of ScheduledScreening objects with the given status
	 */
	List<ScheduledScreening> findByStatus(String string);
	
	/**
	 * Update status of a ScheduledScreening
	 * 
	 * @param screened
	 * @param scheduledScreeningId
	 */
	void updateStatus(String screened, Integer scheduledScreeningId);
}
