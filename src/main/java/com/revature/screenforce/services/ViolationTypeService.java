package com.revature.screenforce.services;

import java.util.List;

import com.revature.screenforce.beans.ViolationType;

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
	
	//5/28 JU
	List<ViolationType> getAll();
}
