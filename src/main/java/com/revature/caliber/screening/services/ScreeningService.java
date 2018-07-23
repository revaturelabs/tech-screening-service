package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.repositories.ScreeningRepository;

@Service
public class ScreeningService {

	@Autowired
	private ScreeningRepository screeningRepository;
	
	public SimpleScreening screeningByScreeningId (Integer screeningId){
		return screeningRepository.findByScreeningId(new SimpleScreening(screeningId));
	}

	public List<Screening> getByStatus(String string) {
		// TODO Auto-generated method stub
		
	}
}
