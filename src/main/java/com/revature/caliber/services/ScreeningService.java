package com.revature.caliber.services;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.wrappers.EndingWrapper;
import com.revature.caliber.wrappers.StartingWrapper;

/**
 * The service for the Screening part of the Screening service.
 *
 * @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
public interface ScreeningService {
	/**
	 * Get a screening by the Id
	 *
	 * @param screeningId Id to filter screenings by
	 * @return The screening with the matching Id
	 */
	Screening getScreening(int screeningId);

	/**
	 * Update aboutMeComment by ScreeningId
	 *
	 * @param aboutMeComment - the comment to be persisted to the database.
	 * @param screeningId    - the unique id of a screening
	 */
	void updateAboutMeComment(String aboutMeComment, int screeningId);

	/**
	 * Update GeneralComment By ScreeningId
	 *
	 * @param generalComment - the comment to be persisted to the database
	 * @param screeningId    - the unique id of a screening
	 */
	void updateGeneralComment(String generalComment, int screeningId);

	/**
	 * Update info after a Screening ends
	 *
	 * @param screeningInfo - Screening info to be updated after a Screening ends
	 */
	void endScreening(EndingWrapper screeningInfo);

	/**
	 * Set a screening as pending
	 *
	 * @param screeningInfo Screening info to be updated after a screening ends
	 * @return Returns the sceening being updated
	 */
	Screening setPending(StartingWrapper screeningInfo);
}

