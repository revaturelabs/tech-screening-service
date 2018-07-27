package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SoftSkillViolation;


@Repository
public interface SoftSkillViolationRepository extends JpaRepository<SoftSkillViolation, Integer> {
	SoftSkillViolation findByScreeningScreeningId(int screeningId);
}
