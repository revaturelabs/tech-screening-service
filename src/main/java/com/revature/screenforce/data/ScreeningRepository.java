package com.revature.screenforce.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Screening;

/**
 * DAO for all Screenings
 * 
 * @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
 */
@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
}

