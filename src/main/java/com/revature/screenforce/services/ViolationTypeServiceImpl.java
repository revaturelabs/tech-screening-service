package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.data.ViolationTypeRepository;

import java.util.List;

/**
 * The implementation of the ViolationTypeService.
 */
@Service
public class ViolationTypeServiceImpl implements ViolationTypeService {

	/** The violation type repository. */
	private ViolationTypeRepository violationTypeRepository;
	
	/**
	 * Instantiates a new violation type service impl.  Autowired.
	 *
	 * @param violationTypeRepository the violation type repository
	 */
	@Autowired
	public ViolationTypeServiceImpl (ViolationTypeRepository violationTypeRepository) {
		this.violationTypeRepository = violationTypeRepository;
	}
	
	/**
	 * Gets the violation type.
	 *
	 * @param id the id
	 * @return the violation type
	 */
	@Override
	public ViolationType getViolationType(int id) {
		return violationTypeRepository.findById(id).orElse(null);
	}

	/**
	 * Gets all violation types.
	 *
	 * @return the all
	 */
	@Override
	public List<ViolationType> getAll() {
		return violationTypeRepository.findAll();
	}


}
