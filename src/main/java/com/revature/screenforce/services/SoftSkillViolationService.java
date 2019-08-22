package com.revature.screenforce.services;

import java.util.List;

import com.revature.screenforce.beans.SoftSkillViolation;

/**
 * Business logic for Soft Skill Violations operations </br>
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins </br>
 * 
 */
public interface SoftSkillViolationService {
	/**
	 * Find a SoftSkillViolation from the database
	 *
	 * @param id SoftSkillViolation Id to find SSV from the database
	 * @return Persistent SoftSkillViolation object
	 */
	SoftSkillViolation findById(int id);
	
	/**
	 * Save a SoftSkillViolation to the database
	 *
	 * @param ssv SoftSkillViolation to save to the database
	 * @return Persistent SoftSkillViolation object
	 */
	SoftSkillViolation save(SoftSkillViolation ssv);

	/**
	 * Delete a SoftSkillViolation from the database
	 *
	 * @param softSkillViolationId Id of the SSV to filter by
	 */
	void delete(int softSkillViolationId);

	/**
	 * Get all SoftSkillViolations associated with a screening
	 *
	 * @param screeningId Id of the screening to filter by
	 * @return List of SoftSkillViolations with the same screeningId
	 */
	List<SoftSkillViolation> getAllByScreeningId(int screeningId);
	
	
	/*
	 * Returns all possible soft skill violations.
	 */
	List<SoftSkillViolation> getAll();
}
