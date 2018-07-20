package com.revature.caliber.service;

import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SimpleScheduledScreening;

@Service
public class ScreeningService {
	/*@Autowired - create beans of screening sessions when you have data access*/
	
	public SimpleScheduledScreening getPendingScreening(Integer id) {
		
		// whatever our messaging service is called, along with whatever the access function is called
		return scms.selectPendingScreening(id);
	}
	
	public SimpleScheduledScreening getPendingScreening() {
		
		// whatever our messaging service is called, along with whatever the access function is called
		return scms.selectPendingScreening();
	}
}
