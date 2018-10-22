package com.revature.screenforce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.data.ScheduledScreeningRepository;
import com.revature.screenforce.data.ScreeningRepository;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	@Autowired
	ScreeningRepository screeningRepository;

	@Autowired
	ScheduledScreeningRepository scheduledScreeningRepository;
	
	@Override
	public List<Screening> getAllScreening() {
		return screeningRepository.findAll();
	}
	
	@Override
	public Screening getScreeningById(int sid) {
//		return screeningRepository.getOne(sid);
		Screening sc = null;
		try {
			sc = screeningRepository.getOne(sid);
		} catch (Exception e) {
			return sc;
		}
		return sc;
	}
	
	@Override
	public Screening getScreening(int id) {
		return screeningRepository.findById(id).orElse(new Screening());
	}

	@Override
	public Screening createScreening(Screening screening) {
		if (screening != null && !(screening.equals(new Screening()))) {
			return screeningRepository.save(screening);
		} else {
			return null;
		}
	}

	@Override
	public Screening updateScreening(Screening screening) {
		if (screening != null && !(screening.equals(new Screening()))) {
			return screeningRepository.save(screening);
		} else {
			return null;
		}
	}
	@Override
	public boolean existsById(int id) {
		return screeningRepository.existsById(id);
	}
}
