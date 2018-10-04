package com.revature.caliber.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;

public class ScheduledScreeningServiceImplTest {
	
	@Autowired
	ScheduledScreeningService scheduledScreeningService;

	@Test
	public void testFindByStatus() {
		
		int size = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		
		assertEquals(size,scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size());
	}

	@Test
	public void testUpdateStatus() {
		int scheduledScreeningId = 1;
		scheduledScreeningService.updateStatus(scheduledScreeningId);
	}

}
