package com.revature.screenforce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.data.ScreeningRepository;

/**
 * The implementation of the Screening Service
 */
@Service
public class ScreeningServiceImpl implements ScreeningService {
	
	/** The screening repository. */
	private ScreeningRepository screeningRepository;

	/**
	 * Instantiates a new screening service impl.  Autowired.
	 *
	 * @param screeningRepository the screening repository
	 */
	@Autowired
	public ScreeningServiceImpl (ScreeningRepository screeningRepository) {
		this.screeningRepository = screeningRepository;
	}
	
	/**
	 * Gets all screenings.
	 *
	 * @return the all screening
	 */
	@Override
	public List<Screening> getAllScreening() {
		return screeningRepository.findAll();
	}

	/**
	 * Gets the screening by id.
	 *
	 * @param sid the sid
	 * @return the screening by id
	 */
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

	/**
	 * Gets the screening by id, returns a new, empty Screening if no such screening exists.
	 *
	 * @param id the id
	 * @return the screening
	 */
	@Override
	public Screening getScreening(int id) {
		return screeningRepository.findById(id).orElse(new Screening());
	}

	/**
	 * Creates the passed screening.  NB: This will also persist the attached Scheduled Screening and the associated Candidate
	 *
	 * @param screening the screening
	 * @return the screening
	 */
	@Override
	public Screening createScreening(Screening screening) {
		if (screening != null && !(screening.equals(new Screening()))) {
			return screeningRepository.save(screening);
		} else {
			return null;
		}
	}

	/**
	 * Update screening.
	 *
	 * @param screening the screening
	 * @return the screening
	 */
	@Override
	public Screening updateScreening(Screening screening) {
		if (screening != null && !(screening.equals(new Screening()))) {
			return screeningRepository.save(screening);
		} else {
			return null;
		}
	}

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	public boolean existsById(int id) {
		return screeningRepository.existsById(id);
	}
}
