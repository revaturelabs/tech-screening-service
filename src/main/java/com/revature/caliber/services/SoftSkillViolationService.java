package com.revature.caliber.services;

import com.revature.caliber.beans.SoftSkillViolation;

import java.util.List;

/**
 * Business logic for Soft Skill Violations operations
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 */
public interface SoftSkillViolationService {
	/**
	 * Save a SoftSkillViolation to the database
	 * 
	 * @param SoftSkillViolation
	 * @return Persistent SoftSkillViolation object
	 */
	SoftSkillViolation save(SoftSkillViolation ssv);
	
	/**
	 * Delete a SoftSkillViolation from the database
	 * 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * Get all SoftSkillViolations associated with a screening
	 * 
	 * @param screeningId
	 * @return List of SoftSkillViolations with the same screeningId
	 */
	List<SoftSkillViolation> getAllByScreeningId(int screeningId);
}
