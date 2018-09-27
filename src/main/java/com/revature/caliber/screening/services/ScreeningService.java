package com.revature.caliber.screening.services;
import com.revature.caliber.screening.wrappers.EndingWrapper;

	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
public interface ScreeningService {

	public void updateAboutMeComment(String aboutMeComment, Integer screeningId);
	public void updateGeneralComment(String generalComment, Integer screeningId);
	public void endScreening(EndingWrapper screeningInfo);
		
	/**
	 * Save a selected screening with status Pending
	 * 
	 * @param screening - Screening object
	 * @return a screening object
	 */
	public Screening setPending(Screening screening);
	
	public Screening getScreening(int id);
}
