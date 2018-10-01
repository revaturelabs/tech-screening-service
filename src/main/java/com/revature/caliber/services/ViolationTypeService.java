package com.revature.caliber.services;

import com.revature.caliber.beans.ViolationType;

import java.util.List;

/**
 * Business logic for Violation Type operations
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
public interface ViolationTypeService {
	/**
	 * Get ViolationType by id
	 *
	 * @param violationTypeId Id of violation to filter by
	 * @return ViolationType
	 */
	ViolationType getViolationType(int violationTypeId);
	
	/**
	 * Get all ViolationTypes
	 * 
	 * @return List of all ViolationTypes
	 */
	List<ViolationType> getAll();
}
