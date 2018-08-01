package com.revature.caliber.screening.services;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.wrappers.StartingWrapper;

public interface ScreeningService {
	
	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	/**
	 * Save a selected screening with status Pending
	 * 
	 * @param screening - Screening object
	 * @return a screening object
	 */
	public Screening setPending(StartingWrapper screeningInfo);
}