package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.ViolationType;

@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Integer> {
	
}
