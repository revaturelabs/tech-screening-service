package com.revature.caliber.services;

import com.revature.caliber.beans.ViolationType;
import com.revature.caliber.data.ViolationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationTypeServiceImpl implements ViolationTypeService {

	@Autowired
	ViolationTypeRepository violationTypeRepository;
	
	@Override
	public ViolationType getViolationType(int id) {
		return violationTypeRepository.findById(id).orElse(null);
	}

	@Override
	public List<ViolationType> getAll() {
		return violationTypeRepository.findAll();
	}


}
