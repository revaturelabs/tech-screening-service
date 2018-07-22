package com.revature.caliber.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SimpleScreening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer>{
	
	// Returns SimpleScreening object that contains the SimpleScheduledScreeningId
	SimpleScreening getBySimpleScheduledScreeningId(Integer simpleScheduledScreeningId);
	
	// Returns id of SimpleScreening object
	Integer getId(SimpleScreening simpleScreening);
}
