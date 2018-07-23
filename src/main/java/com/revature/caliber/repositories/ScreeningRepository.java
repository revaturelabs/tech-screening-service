package com.revature.caliber.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.beans.SimpleScheduledScreening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer>{
	
	// Returns SimpleScreening object that contains the SimpleScheduledScreeningId
	SimpleScreening findBySimpleScheduledScreening(SimpleScheduledScreening simpleScheduledScreening);
	
	// Returns id of SimpleScreening object
	Integer screeningId(SimpleScreening simpleScreening);
}
