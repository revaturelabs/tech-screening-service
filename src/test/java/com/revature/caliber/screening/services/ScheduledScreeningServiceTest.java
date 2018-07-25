package com.revature.caliber.screening.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.screening.Application;

/**
 * Scheduled Screening Service Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScheduledScreeningServiceTest {
	
	@Autowired
	ScheduledScreeningService sss;
	
	
	@Test
	public void findPendingTest() {
		List<ScheduledScreening> scheduledScreenings = sss.findByStatus("PENDING");
		assertTrue(scheduledScreenings != null && !scheduledScreenings.isEmpty());
	}
	
	@Test
	public void updateStatusTest() {
		List<ScheduledScreening> scheduledScreenings = sss.findByStatus("PENDING");
		int count = scheduledScreenings.size();

		ScheduledScreening scheduledScreening = scheduledScreenings.get(0);
		sss.updateStatus("SCREENED", scheduledScreening);
		scheduledScreenings = sss.findByStatus("PENDING");

		assertTrue(count > scheduledScreenings.size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateStatusTestIllegalArgument() {
		List<ScheduledScreening> scheduledScreenings = sss.findByStatus("PENDING");
		int count = scheduledScreenings.size();

		ScheduledScreening scheduledScreening = scheduledScreenings.get(0);
		sss.updateStatus("invalid input", scheduledScreening);
	}
	
	
	@Test
	public void findPendingTestIllegalArgument() {
		List<ScheduledScreening> scheduledScreenings = sss.findByStatus("invalid input");
		assertTrue(scheduledScreenings == null);
	}
	
	
}
