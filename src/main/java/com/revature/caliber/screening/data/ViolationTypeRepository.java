package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.ViolationType;

/**
 * A JpaRepository for interacting with the ViolationType H2 database
 * 
 * @author sungkwon
 */
@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Integer>{
	
	/**
	 * Returns a ViolationType object with the given unique id
	 * 
	 * @param violationId - a unique id of a ViolationType object
	 * @return A ViolationType object
	 */
	@Query("select v.violationTypeText from ViolationType v where v.violationTypeId =?1")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	String findViolationTypeTextByViolationTypeId(Integer violationId);
	
}
