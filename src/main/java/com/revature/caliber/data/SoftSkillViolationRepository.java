package com.revature.caliber.data;

import com.revature.caliber.beans.SoftSkillViolation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
