package com.revature.caliber.screening.services;

import java.util.List;

import com.revature.caliber.beans.ViolationType;

/**
 * Business logic for Violation Type operations
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 */
public interface ViolationTypeService {
	/**
	 * Get ViolationType by id
	 * 
	 * @param id
	 * @return ViolationType
	 */
	ViolationType getViolationType(int id);
	
	/**
	 * Get all ViolationTypes
	 * 
	 * @return List of all ViolationTypes
	 */
	List<ViolationType> getAll();
}
