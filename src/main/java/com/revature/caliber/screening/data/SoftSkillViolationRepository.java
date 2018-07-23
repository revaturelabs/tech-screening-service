package com.revature.caliber.screening.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.beans.SoftSkillViolation;

/**
 * A JpaRepository for interacting with the SoftSkillViolation H2 database
 * 
 * @author sungkwon, echamp
 */
@Repository
public interface SoftSkillViolationRepository extends JpaRepository<SoftSkillViolation, Integer>{
	
	/**
	 * Returns a list of SoftSkillViolation objects by relation to SimpleScreening
	 * 
	 * @param ss - a SimpleScreening that is related to SoftSkillViolation objects
	 * @return A list of SoftSkillViolation objects
	 */
	List<SoftSkillViolation> findByScreeningId(SimpleScreening ss);
}
