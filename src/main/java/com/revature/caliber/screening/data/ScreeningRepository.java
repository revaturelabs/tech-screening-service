package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SimpleScheduledScreening;
import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.beans.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer> {
	 // @author Jakob
	
	/*
	 *  Returns SimpleScreening object that contains the SimpleScheduledScreeningId
	 *  
	 *  @param simpleScheduledScreening - A simpleScheduledScreening object
	 *  @return SimpleScreening object
	 */
	SimpleScreening findBySimpleScheduledScreening(SimpleScheduledScreening simpleScheduledScreening);
	
	/*
	 *  Returns id of SimpleScreening object
	 *  
	 *  @param simpleScreening - A ScreeningObject
	 *  @return unique id of a screening object
	 */
	Integer screeningId(Screening screening);
}
