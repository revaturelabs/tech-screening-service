package com.revature.caliber.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.SimpleScreening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer>{
	List<SimpleScreening> getByStatus(String status);
	
	void setStatus(String status);
	
	@RequestMapping(value = "/screening/pending/{simpleScheduledScreeningId}")
	public SimpleScreening pendingScreeningsByScreeningId(@PathVariable (value="simpleScheduledScreeningId") Integer simpleScheduledScreeningId){
		
	}
}
