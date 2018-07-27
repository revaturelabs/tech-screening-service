package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.screening.data.SoftSkillViolationRepository;

public class SoftSkillViolationServiceImpl implements SoftSkillViolationService {

	@Autowired
	SoftSkillViolationRepository softSkillViolationRepository;
	
	@Override
	public SoftSkillViolation save(SoftSkillViolation ssv) {
		return softSkillViolationRepository.save(ssv);
	}

	@Override
	public void delete(int id) {
		softSkillViolationRepository.delete(id);

	}

	@Override
	public List<SoftSkillViolation> getAllByScreeningId(int screeningId) {
		return softSkillViolationRepository.findAllByScreeningId(screeningId);
	}

}
