package com.revature.caliber.screening.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.data.ScreeningRepository;

@Service
public class ScreeningServiceImpl implements ScreeningService{
	
	// @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	@Autowired
	ScreeningRepository screeningRepository;
	
	public Screening setPending(Screening screening) {
		screening.setStatus("Pending");
		return screeningRepository.save(screening);
	}

}
