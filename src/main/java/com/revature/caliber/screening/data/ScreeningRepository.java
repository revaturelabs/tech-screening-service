package com.revature.caliber.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Screening;


@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
	 // @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
}

