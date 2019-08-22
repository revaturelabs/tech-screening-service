package com.revature.screenforce.services;

import java.util.List;

import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;

/**
 * Business logic for Scheduled Screening operations </br>
 * @author Jeremy Straus | 1807-QC | Emily Higgins </br>
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
