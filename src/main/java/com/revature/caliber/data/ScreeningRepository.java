package com.revature.caliber.data;

import com.revature.caliber.beans.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
	 // @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
}

