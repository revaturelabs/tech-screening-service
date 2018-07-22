package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.screening.data.ScheduledScreeningRepository;

@Service
public class ScheduledScreeningServiceImpl implements ScheduledScreeningService {

	@Autowired 
	private ScheduledScreeningRepository ssr;
	
	@Override
	public List<ScheduledScreening> findByStatus(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(String screened, Integer scheduledScreeningId) {
		ssr.updateStatus(screened, scheduledScreeningId);
	}

}
