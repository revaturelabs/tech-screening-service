package com.revature.caliber.screening.services;

import com.revature.caliber.beans.Screening;

public interface ScreeningService {
	
	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	/**
	 * Save a selected screening with status Pending
	 * 
	 * @param screening - Screening object
	 * @return a screening object
	 */
	public Screening setPending(Screening screening);
}