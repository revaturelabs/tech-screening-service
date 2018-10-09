package com.revature.screenforce.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.ViolationType;

/**
 * DAO for ViolationType
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 */
@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Integer> {
	
}
