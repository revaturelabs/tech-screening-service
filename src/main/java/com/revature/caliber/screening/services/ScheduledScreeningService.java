package com.revature.caliber.screening.services;

import java.util.List;

import com.revature.caliber.beans.ScheduledScreening;

/**
 * Business logic for Scheduled Screening operations
 */
public interface ScheduledScreeningService {
	
	/**
	 * Get ScheduledScreening by status
	 * 
	 * @param status "PENDING","SCREENED"
	 * @return list of ScheduledScreening objects with the given status
	 */
	List<ScheduledScreening> findByStatus(String status);
	
	/**
	 * Update status of a ScheduledScreening
	 * Throws IllegalArgumentException if screened is not "PENDING" or "SCREENED"
	 * 
	 * @param screened "PENDING","SCREENED"
	 * @param scheduledScreeningId ID of the ScheduledScreening object to be updated
	 */
	void updateStatus(String screened, Integer scheduledScreeningId) throws IllegalArgumentException;
}
