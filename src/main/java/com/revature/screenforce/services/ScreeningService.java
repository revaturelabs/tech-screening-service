package com.revature.screenforce.services;

import java.util.List;

import com.revature.screenforce.beans.Screening;

/**
 * The service for the Screening part of the Screening service. </br>
 * @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * 
 */
public interface ScreeningService {
	/**
	 * Get a screening by the Id
	 *
	 * @param screeningId Id to filter screenings by
	 * @return The screening with the matching Id
	 */
	Screening getScreening(int screeningId);
	Screening getScreeningById(int sid);
	List<Screening> getAllScreening();
	/**
	 * Persist a new Screening
	 *
	 * @param screening Screening to persist
	 * @return The new screening object
	 */
	Screening createScreening(Screening screening);

	/**
	 * Update an already persistent screening
	 *
	 * @param screening Screening to update
	 * @return The updated screening object
	 */
	Screening updateScreening(Screening screening);
	boolean existsById(int id);
}

