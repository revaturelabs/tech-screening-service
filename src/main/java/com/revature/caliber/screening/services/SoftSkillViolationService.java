package com.revature.caliber.screening.services;

import com.revature.caliber.beans.SoftSkillViolation;

public interface SoftSkillViolationService {
	SoftSkillViolation save(SoftSkillViolation ssv);
	void delete(int id);
	SoftSkillViolation getByScreeningId(int screeningId);
}
