package com.revature.caliber.services;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;

import java.util.List;

/**
 * Business logic for Scheduled Screening operations
 *
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
public interface ScheduledScreeningService {

	/**
	 * Get ScheduledScreening by status
	 *
	 * @param status "PENDING","SCREENED"
	 * @return list of ScheduledScreening objects with the given status
	 */
	List<ScheduledScreening> findByStatus(ScheduledStatus status);

	/**
	 * Update status of a ScheduledScreening
	 * Throws IllegalArgumentException if screened is not "PENDING" or "SCREENED"
	 *
	 * @param scheduledScreeningId ID of the ScheduledScreening object to be updated
	 */

	void updateStatus(int scheduledScreeningId);

}
