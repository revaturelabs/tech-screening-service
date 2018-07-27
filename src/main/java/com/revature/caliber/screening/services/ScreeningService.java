package com.revature.caliber.screening.services;
import com.revature.caliber.screening.wrapper.EndingWrapper;

public interface ScreeningService {

	public void updateAboutMeComment(String aboutMeComment, Integer screeningId);
	public void updateGeneralComment(String generalComment, Integer screeningId);
	public void endScreening(EndingWrapper screeningInfo);
}
