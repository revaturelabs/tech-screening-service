package com.revature.caliber.services;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.wrappers.EndingWrapper;
import com.revature.caliber.wrappers.StartingWrapper;


public interface ScreeningService {
	
	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	

	public Screening getScreening(int id);
	public void updateAboutMeComment(String aboutMeComment, Integer screeningId);
	public void updateGeneralComment(String generalComment, Integer screeningId);
	public void endScreening(EndingWrapper screeningInfo);
	public Screening setPending(StartingWrapper screeningInfo);
}

