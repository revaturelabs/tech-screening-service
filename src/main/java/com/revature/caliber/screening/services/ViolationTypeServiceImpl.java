package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ViolationType;
import com.revature.caliber.screening.data.ViolationTypeRepository;

@Service
public class ViolationTypeServiceImpl implements ViolationTypeService {

	@Autowired
	ViolationTypeRepository violationTypeRepository;
	
	@Override
	public ViolationType getViolationType(int id) {
		return violationTypeRepository.findOne(id);
	}

	@Override
	public List<ViolationType> getAll() {
		return violationTypeRepository.findAll();
	}


}
