package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.data.SoftSkillViolationRepository;

import java.util.List;

/**
 * The implementation of the SoftSkillViolationService.
 */
@Service
public class SoftSkillViolationServiceImpl implements SoftSkillViolationService {

	/** The soft skill violation repository. */
	private SoftSkillViolationRepository softSkillViolationRepository;
	
	/**
	 * Instantiates a new soft skill violation service impl.  Autowired.
	 *
	 * @param softSkillViolationRepository the soft skill violation repository
	 */
	@Autowired
	public SoftSkillViolationServiceImpl(SoftSkillViolationRepository softSkillViolationRepository) {
		this.softSkillViolationRepository = softSkillViolationRepository;
	}

	/**
	 * Save a new soft skill violation.
	 *
	 * @param ssv the soft skill violation
	 * @return the soft skill violation
	 */
	@Override
	public SoftSkillViolation save(SoftSkillViolation ssv) {
		if (ssv != null && !(ssv.equals(new SoftSkillViolation()))) {
			return softSkillViolationRepository.save(ssv);
		} else {
			return null;
		}
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(int id) {
		softSkillViolationRepository.deleteById(id);
	}

	/**
	 * Gets all soft skill violations by screening id.
	 *
	 * @param screeningId the screening id
	 * @return the all by screening id
	 */
	@Override
	public List<SoftSkillViolation> getAllByScreeningId(int screeningId) {
		return softSkillViolationRepository.findAllByScreeningScreeningId(screeningId);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the soft skill violation
	 */
	@Override
	public SoftSkillViolation findById(int id) {
		return softSkillViolationRepository.getOne(id);
	}
	
	/**
	 * Hilarious auto generated description: Gets the all. </br></br>
	 * What it actually does: returns all soft skill violations.
	 *
	 * @return the all
	 */
	public List<SoftSkillViolation> getAll() {
		return softSkillViolationRepository.findAll();
	}
}
