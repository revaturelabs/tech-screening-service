package com.revature.caliber.screening.services;

import java.util.List;

import com.revature.caliber.beans.SoftSkillViolation;

public interface SoftSkillViolationService {
	SoftSkillViolation save(SoftSkillViolation ssv);
	void delete(int id);
	List<SoftSkillViolation> getAllByScreeningId(int screeningId);
}
