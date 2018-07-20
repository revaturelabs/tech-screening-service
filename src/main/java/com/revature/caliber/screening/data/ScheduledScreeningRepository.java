package com.revature.caliber.screening.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.SimpleScheduledScreening;

/**
 * DAO for ScheduledScreening
 */
public interface ScheduledScreeningRepository extends JpaRepository<SimpleScheduledScreening, Integer> {

	/**
	 * Finds the SimpleScheduledScreening instances associated
	 * with the given Status string
	 * 
	 * @param string Status string
	 * @return List of SimpleScheduledScreening instances associated
	 * with the given Status string
	 */
	List<SimpleScheduledScreening> findByStatus(String string);

	/**
	 * Sets the status to given string
	 * 
	 * @param screened New Status string
	 * @param scheduledScreeningId Id of ScheduledScreening
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScheduledScreening s set s.status = ?1 where s.scheduledScreeningId = ?2")
	void updateStatus(String screened, Integer scheduledScreeningId);

}
