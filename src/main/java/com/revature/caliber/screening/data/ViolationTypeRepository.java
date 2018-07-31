package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.ViolationType;

/**
 * DAO for ViolationType
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 */
@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Integer> {
	
}
