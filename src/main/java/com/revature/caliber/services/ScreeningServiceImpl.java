package com.revature.caliber.services;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.data.ScheduledScreeningRepository;
import com.revature.caliber.data.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	@Autowired
	ScreeningRepository screeningRepository;

	@Autowired
	ScheduledScreeningRepository scheduledScreeningRepository;

	@Override
	public Screening getScreening(int id) {
		return screeningRepository.findById(id).orElse(new Screening());
	}

	@Override
	public Screening createScreening(Screening screening) {
		if (screening != null && screening != new Screening()) {
			return screeningRepository.save(screening);
		} else {
			return null;
		}
	}

	@Override
	public Screening updateScreening(Screening screening) {
		if (screening != null && screening != new Screening()) {
			return screeningRepository.save(screening);
		} else {
			return null;
		}
	}
}
