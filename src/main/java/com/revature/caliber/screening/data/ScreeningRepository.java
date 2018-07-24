package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
	 // @author Jakob
	
	/*
	 *  Returns id of Screening object
	 *  
	 *  @param simpleScreening - A ScreeningObject
	 *  @return unique id of a screening object
	 */
	Integer screeningId(Screening screening);
}
