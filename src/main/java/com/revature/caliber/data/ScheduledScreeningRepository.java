package com.revature.caliber.data;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for ScheduledScreening
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 */
@Repository
public interface ScheduledScreeningRepository extends JpaRepository<ScheduledScreening, Integer> {

	/**
	 * Finds the SimpleScheduledScreening instances associated
	 * with the given Status string
	 * 
	 * @param status "PENDING","SCREENED"
	 * @return List of SimpleScheduledScreening instances associated
	 * with the given Status string
	 */
	List<ScheduledScreening> findAllByScheduledStatus(ScheduledStatus status);

}
