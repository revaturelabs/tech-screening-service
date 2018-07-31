package com.revature.caliber.screening.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SoftSkillViolation;

/**
 * DAO for SoftSkillViolation
 *
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 */
@Repository
public interface SoftSkillViolationRepository extends JpaRepository<SoftSkillViolation, Integer> {
	/**
	 * Get SoftSkillViolations by screeningId
	 * 
	 * @param screeningId
	 * @return List of SoftSkillViolations with the same screeningId
	 */
	List<SoftSkillViolation> findAllByScreeningId(int screeningId);
}
