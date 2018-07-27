package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Screening;

/**
 * A JpaRepository for interacting with the Screening H2 database
 * 
 * @author Thomas Santillan
 */
@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
	
}
