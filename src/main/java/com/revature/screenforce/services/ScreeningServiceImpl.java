package com.revature.screenforce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.data.ScreeningRepository;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	
	private ScreeningRepository screeningRepository;
	
	@Autowired
	public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
		super();
		this.screeningRepository = screeningRepository;
	}

	@Override
	public List<Screening> getAllScreenings() {
		return screeningRepository.findAll();
	}

	@Override
	public Screening getScreeningById(int sid) {
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
