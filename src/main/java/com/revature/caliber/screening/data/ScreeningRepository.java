package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SimpleScheduledScreening;
import com.revature.caliber.beans.SimpleScreening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer> {
	// Returns SimpleScreening object that contains the SimpleScheduledScreeningId
	SimpleScreening findBySimpleScheduledScreening(SimpleScheduledScreening simpleScheduledScreening);
	
	// Returns id of SimpleScreening object
	Integer screeningId(SimpleScreening simpleScreening);
}
