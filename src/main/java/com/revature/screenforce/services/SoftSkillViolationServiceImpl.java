package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.data.SoftSkillViolationRepository;

import java.util.List;

@Service
public class SoftSkillViolationServiceImpl implements SoftSkillViolationService {

	@Autowired
	SoftSkillViolationRepository softSkillViolationRepository;

	@Override
	public SoftSkillViolation save(SoftSkillViolation ssv) {
		if (ssv != null && !(ssv.equals(new SoftSkillViolation()))) {
			return softSkillViolationRepository.save(ssv);
		} else {
			return null;
		}
	}

	@Override
	public void delete(int id) {
		softSkillViolationRepository.deleteById(id);
	}

	@Override
	public List<SoftSkillViolation> getAllByScreeningId(int screeningId) {
		return softSkillViolationRepository.findAllByScreeningScreeningId(screeningId);
	}

	@Override
	public SoftSkillViolation findById(int id) {
		return softSkillViolationRepository.getOne(id);
	}
}
